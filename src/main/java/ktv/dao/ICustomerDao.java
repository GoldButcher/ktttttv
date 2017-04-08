package ktv.dao;

import ktv.dto.CustomerInfoDto;
import ktv.model.Customer;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface ICustomerDao extends AbstractDao<Integer, Customer> {

    List<CustomerInfoDto> getAllCustomerByDate(String date);
}
