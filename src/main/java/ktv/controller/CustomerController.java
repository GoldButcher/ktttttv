package ktv.controller;

import ktv.dto.CommonResponseDto;
import ktv.dto.CustomerInfoDto;
import ktv.dto.ListBoxDto;
import ktv.model.Customer;
import ktv.service.ICustomerService;
import ktv.util.CommonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
