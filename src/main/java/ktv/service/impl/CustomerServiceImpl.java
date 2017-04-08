package ktv.service.impl;

import ktv.dao.AbstractDao;
import ktv.dao.ICustomerDao;
import ktv.dto.CustomerInfoDto;
import ktv.model.Customer;
import ktv.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
}
