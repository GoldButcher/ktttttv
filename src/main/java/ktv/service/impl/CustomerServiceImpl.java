package ktv.service.impl;

import ktv.dao.AbstractDao;
import ktv.dao.ICustomerDao;
import ktv.dto.CommonResponseDto;
import ktv.dto.CustomerInfoDto;
import ktv.model.Customer;
import ktv.service.ICustomerService;
import ktv.util.CheckUtil;
import ktv.util.CommonResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class CustomerServiceImpl extends AbstractServiceimpl<Integer,Customer> implements ICustomerService{
    @Resource
    private ICustomerDao customerDao;

    @Resource
    public void setCustomerDao(ICustomerDao customerDao) {
        super.setAbstractDao(customerDao);
    }

    @Override
    public List<CustomerInfoDto> getAllCustomerByDate(String date) {
        return customerDao.getAllCustomerByDate(date);
    }

    @Override
    public CommonResponseDto getCheck(String mobile, HttpSession session) throws Exception {
        CheckUtil.send(mobile,session);
        return CommonResponseUtil.successWithNull();
    }

    @Override
    public CommonResponseDto check(String str, HttpSession session) {
        return CheckUtil.check(str,session);
    }
}
