package com.qdu.controller;

import com.qdu.bean.*;
import com.qdu.service.ShopItemService;
import com.qdu.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2019/5/2.
 */
@Controller
@RequestMapping(value = "/shopItem")
public class ShopItemController {
    @Autowired
    ShopItemService shopItemService;

    /**
     * 得到商品列表
     * @param page
     * @param rows
     * @param shopItem_descript
     * @param request
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Map<String ,Object> GetList(Integer page, Integer rows,ShopItem_Descript shopItem_descript,HttpServletRequest request){
    User user = (User) request.getSession().getAttribute("user");
    if (shopItem_descript.getShopid()!=null&&shopItem_descript.getShopid()!=0){

    }else{
        shopItem_descript.setShopid(user.getShopId());
    }
    Map<String ,Object> map = shopItemService.getList(page,rows,shopItem_descript);
    return map;
    }

    /**
     * 得到商品详情
     * @param shopitemid
     * @return
     */
    @RequestMapping(value = "/getDetail")
    public String getDetail(Integer shopitemid, HttpServletRequest request){
        Shopitemdescrip shopitemdescrip = shopItemService.getDetail(shopitemid);
        request.setAttribute("shopitemdescrip",shopitemdescrip);
        return "shopitem/itemDetail";
    }

    @RequestMapping(value = "/queryBySupplierid")
    public String queryBySupplierid(int supplierid, HttpServletRequest request){
        request.setAttribute("supplierid",supplierid);
        return "supplier/itemDetail";
    }


    @RequestMapping(value = "/update")
    public String update(Integer shopitemid,Integer shopid,HttpServletRequest request) {
        /*Shopitemdescrip shopitemdescrip = shopItemService.getDetail(shopitemid);*/
        User user = (User) request.getSession().getAttribute("user");

        if (shopid!=null){

        }else{
            shopid = user.getShopId();
        }
        ShopItem_Descript shopItem_descript = shopItemService.getDetail2(shopitemid,shopid);
        request.setAttribute("shopitemdescrip", shopItem_descript);

        return "shopitem/itemUpdate";
    }

    @RequestMapping(value = "/update2")
    @ResponseBody
    public ResultMsg update2(Shopitemdescrip shopitemdescrip,Integer num,Integer ifgrounding,Integer shopid , HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();
        User user = (User)request.getSession().getAttribute("user");
        int sid =  user.getShopId();
        int i =1;
        if(sid==1){
            i = shopItemService.update(shopitemdescrip);
        }
        Shopitem shopitem = new Shopitem();
        shopitem.setIfgrounding(ifgrounding);
        shopitem.setShopitemid(shopitemdescrip.getShopitemid());
        shopitem.setShopid(shopid);
        shopitem.setNum(num);
        shopItemService.updateShopItem(shopitem);
        if(i>=1){
            msg.setCode(200);
            msg.setMsg("修改商品成功");
        }else{
            msg.setCode(500);
            msg.setMsg("修改失败");
        }
        return msg;
    }

    @RequestMapping(value="/add")
    @ResponseBody
    public ResultMsg add(Shopitemdescrip shopitemdescrip,Integer ifgrounding, HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();

        int i = shopItemService.add(shopitemdescrip);


        //得到所有 shopid 添加到  shopitem 表
        User user = (User) request.getSession().getAttribute("user");
        int shopid = user.getShopId();
        Shopitem shopitem = new Shopitem();
        shopitem.setShopid(user.getShopId());
        shopitem.setShopitemid(shopitemdescrip.getShopitemid());
        //默认上架
        shopitem.setIfgrounding(ifgrounding);
        shopitem.setNum(0);
        shopItemService.add(shopitem);

        if(i>=1){
            msg.setCode(200);
            msg.setMsg("添加商品成功");
        }else{
            msg.setCode(500);
            msg.setMsg("添加失败");
        }
        return msg;
    }


    @RequestMapping(value="/batchAdding")
    @ResponseBody
    public ResultMsg batchAdding(MultipartFile file,HttpSession session) {
        ResultMsg msg = new ResultMsg();
        Object user = session.getAttribute("user");
        if(user == null) {
            msg.setCode(403);
            msg.setMsg("登录后重试!");
            return msg;
        }

        try {
            return shopItemService.add(((User)user).getShopId(),file);
        } catch(Exception e) {
            msg.setCode(500);
            msg.setMsg(e.getMessage());
            return msg;
        }

    }


}
