package ktv.service;

import ktv.dto.CustomerInfoDto;
import ktv.model.Customer;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface ICustomerService extends AbstractService<Integer,Customer>{
    List<CustomerInfoDto> getAllCustomerByDate(String date);
}
