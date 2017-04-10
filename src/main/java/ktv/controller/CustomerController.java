package ktv.controller;

import ktv.dto.CommonResponseDto;
import ktv.dto.CustomerInfoDto;
import ktv.dto.ListBoxDto;
import ktv.model.Customer;
import ktv.service.ICustomerService;
import ktv.util.CheckUtil;
import ktv.util.CommonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by evan on 2017/1/4.
 */
@RestController
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    /**
     * @title:保存用户
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 14:59
     **/
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public CommonResponseDto saveCustomer(Customer customer) {
        customerService.sava(customer);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:通过日期获取所有用户
     * @user:admin
     * @return:java.util.List<ktv.dto.CustomerInfoDto
     * @date:2017/1/8 14:59
     **/
    @RequestMapping(value = "/getAllCustomerByDate", method = RequestMethod.GET)
    public List<CustomerInfoDto> getAllCustomerByDate(String date) {
        Assert.notNull(date);
        return customerService.getAllCustomerByDate(date);
    }

//    /**
//     * @title:用户获取验证码
//     * @user:admin
//     * @return:CommonResponseDto
//     * @date:2017/4/9 14:59
//     **/
//    @RequestMapping(value = "/getCheck",method = RequestMethod.GET)
//    public CommonResponseDto getCheck(String mobile,HttpSession session){
//        try {
//            return customerService.getCheck(mobile, session);
//        } catch (Exception e) {
//            return CommonResponseUtil.errorWithObj("网络错误,请重新获取");
//        }
//    }
//
//    /**
//     * @title:验证码验证函数
//     * @user:admin
//     * @return:CommonResponseDto
//     * @date:2017/4/9 14:59
//     **/
//    @RequestMapping(value = "check",method = RequestMethod.GET)
//    public CommonResponseDto check(String checkCode,HttpSession session){
//        return customerService.check(checkCode,session);
//    }
    /**
          * @title:客户登陆
          * @user:admin
          * @return:ModelAndView
          * @date:2017/4/9 14:59
     **/
    @RequestMapping(value = "/customerLogin")
    public ModelAndView customerLogin(HttpServletRequest request){
        return customerService.customerLogin(request);
    }

    @RequestMapping(value = "/getOpenId",method = RequestMethod.GET)
    public CommonResponseDto getOpendId(HttpSession session){
        String openid = (String) session.getAttribute("openid");
        System.out.println(openid);
        return CommonResponseUtil.successWithObj(openid);
    }
}
