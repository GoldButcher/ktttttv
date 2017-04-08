package ktv.controller;

import ktv.dto.CommonResponseDto;
import ktv.model.Shop;
import ktv.service.IShopService;
import ktv.util.CommonResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by admin on 2016/12/29.
 */
@RestController
public class ShopController {
    @Resource
    private IShopService shopService;

    /**
     * @title:回显公司信息
     * @user:clj
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/2 14:35
     **/
    @RequestMapping(value = "/shopInfo",method = RequestMethod.GET)
    public CommonResponseDto getShopInfo()
    {
        List<Shop> shops = shopService.getAll();
        if(0 == shops.size())
            return CommonResponseUtil.shopNotExist();
        else
            return CommonResponseUtil.successWithObj(shops.get(0));
    }

    /**
     * @title:更新公司信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/2 20:51
     **/
    @RequestMapping(value = "/shopInfo",method = RequestMethod.POST)
    public CommonResponseDto updateShopInfo(Shop shop)
    {
        List<Shop> shops = shopService.getAll();
        if(0 == shops.size())
            return CommonResponseUtil.shopNotExist();
        else {
            Shop oldshop = shops.get(0);
            oldshop.setDescription(shop.getDescription());
            oldshop.setAboutUs(shop.getAboutUs());
            oldshop.setFixLinePhone(shop.getFixLinePhone());
            oldshop.setLocation(shop.getLocation());
            oldshop.setShopNO(shop.getShopNO());
            oldshop.setWeixin(shop.getWeixin());
            shopService.update(oldshop);
        }
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:获取关于我们字段
     * @user:clj
     * @return:ktv.dto.CommonResponseDto
     * @date:2016/12/29 22:13
     **/
    @RequestMapping(value = "/getAboutUs",method = RequestMethod.GET)
    public CommonResponseDto getAboutUs(HttpServletRequest request)
    {
        List<Shop> shops = shopService.getAll();
        if(0 == shops.size())
        return CommonResponseUtil.shopNotExist();

        return CommonResponseUtil.successWithObj(shops.get(0).getAboutUs());

    }

    /**
     * @title:获取公司简介
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/2 14:30
     **/
    @RequestMapping(value = "/getDescription",method = RequestMethod.GET)
    public CommonResponseDto getDescription(HttpServletRequest request)
    {
        List<Shop> shops = shopService.getAll();
        if(0 == shops.size())
            return CommonResponseUtil.shopNotExist();
        return  CommonResponseUtil.successWithObj(shops.get(0).getDescription());
    }

}
