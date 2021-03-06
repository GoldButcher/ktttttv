package ktv.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ktv.dto.CommonResponseDto;
import ktv.dto.PersonOrderDto;
import ktv.model.BoxBookInfo;
import ktv.model.BoxInfo;
import ktv.service.IBoxBookInfoService;
import ktv.service.IBoxInfoService;
import ktv.util.CommonResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/1/3.
 */
@RestController
public class BoxBookController {
    @Resource
    private IBoxBookInfoService boxBookInfoService;

    @Resource
    private IBoxInfoService boxInfoService;


    /**
     * @title:包厢预定后台入口
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 14:57
     **/
    @RequestMapping(value = "/bookBox", method = RequestMethod.POST)
    public CommonResponseDto bookBox(String date, String boxNo, String weixin, String telephone, int payment, String username, String description) {
        return boxBookInfoService.bookBox(date, boxNo, weixin, telephone, payment, username, description);
    }

    /**
     * @title:取消预定
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 14:57
     **/
    @RequestMapping(value = "/bookBoxCancel", method = RequestMethod.POST)
    public CommonResponseDto cancelBookBox(String date, String boxNo, String telephone) {
        return boxBookInfoService.cancelBookBox(date, boxNo, telephone);
    }

    /**
     * @title:包厢预定微信入口
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 14:57
     **/
    @RequestMapping(value = "/bookBoxFromWeixin", method = RequestMethod.POST)
    public CommonResponseDto bookBoxFromWeixin(String date, int typeId, String weixin, String telephone, String userName, String description) {
        BoxInfo boxInfo = boxInfoService.getEmptyBox(date, typeId);
        if (boxInfo == null) return CommonResponseUtil.errorWithObj("包厢已经全部预定完!");
        return boxBookInfoService.bookBox(date, boxInfo.getBoxNo(), weixin, telephone, 1, userName, description);
    }

    /**
     * @title:获取用户订单微信入口
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 19:45
     **/
    @RequestMapping(value = "/getBookInfoFromWeixin", method = RequestMethod.POST)
    public CommonResponseDto getBookInfoFromWeixin(String weixin) {
        return CommonResponseUtil.successWithObj(boxBookInfoService.getBookInfoFromWeixin(weixin));
    }

    /**
     * @title:支付接口
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 20:16
     **/
    @RequestMapping(value = "/payOrder", method = RequestMethod.POST)
    public CommonResponseDto payOrder(String date, String boxNo, int payment) {
        return boxBookInfoService.payOrder(date, boxNo, payment);
    }


    @PostMapping("/changePayMethod")
    public CommonResponseDto changeBoxPayment(int method, int boxNo) {
        BoxBookInfo box = boxBookInfoService.getByKey(boxNo);
        box.setPayment(method);
        boxBookInfoService.update(box);
        return CommonResponseUtil.successWithNull();
    }

    @GetMapping("/getOrdersByWeixin")
    public CommonResponseDto getOrderByWeixin(String wx) {
        return CommonResponseUtil.successWithObj(boxBookInfoService.getOrderByWx(wx));
    }

    @GetMapping("/getSingleBox")
    public CommonResponseDto getSingleBox(int id) {
        return CommonResponseUtil.successWithObj(boxBookInfoService.getByKey(id));
    }

    @GetMapping("/getSingleBookBoxInfo")
    public CommonResponseDto getSingleBookBoxInfo(int id) {
        return CommonResponseUtil.successWithObj(boxBookInfoService.getSingleBookBoxInfo(id));
    }
}
