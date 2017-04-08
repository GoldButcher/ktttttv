package ktv.dao.impl;

import ktv.dao.ICustomerDao;
import ktv.dto.CustomerInfoDto;
import ktv.model.Customer;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Repository
public class CustomerDaoImpl extends AbstractDaoImpl<Integer, Customer> implements ICustomerDao {
    @Override
    public List<CustomerInfoDto> getAllCustomerByDate(String date) {
        String sql = "SELECT c.weixin AS weixin,c.telephone AS telephone,bb.orderDate AS orderDate "
                    +" FROM BoxBookInfo bb LEFT OUTER JOIN Customer c ON bb.customerId = c.customerId"
                    +" WHERE bb.orderDate =:orderDate";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(CustomerInfoDto.class));

        return query.list();
    }
}
