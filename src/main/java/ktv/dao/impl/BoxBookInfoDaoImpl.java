package ktv.dao.impl;

import ktv.dao.IBoxBookInfoDao;
import ktv.dto.ListBoxDto;
import ktv.dto.PersonOrderDto;
import ktv.model.BoxBookInfo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Repository
public class BoxBookInfoDaoImpl extends AbstractDaoImpl<Integer, BoxBookInfo> implements IBoxBookInfoDao {

    @Override
    public BoxBookInfo getOrder(String boxNo, String date) {
        String hql = "select bb from  BoxInfo bf ,BoxBookInfo bb where bf.boxInfoId = bb.boxInfoId "+
                " and bf.boxNo=:boxNo and bb.orderDate=:orderDate";
        Query query = getSession().createQuery(hql);
        query.setString("boxNo",boxNo).setString("orderDate",date);
        return (BoxBookInfo) query.uniqueResult();
    }

    @Override
    public PersonOrderDto getBooxInfo4Order(BoxBookInfo boxBookInfo) {
        String sql = "SELECT bb.orderDate AS orderDate,bt.name AS boxTypeName,bf.price AS price, bf.boxNo AS boxNo"
                +" ,cs.telephone AS telephone "
                +"FROM BoxBookInfo bb , BoxInfo bf,Customer cs,BoxType bt WHERE"
                +" bb.boxInfoId = bf.boxInfoId and bf.boxTypeId = bt.boxTypeId AND bb.customerId = cs.customerId AND"
                +" bb.orderDate = :orderDate AND bb.boxInfoId = :boxInfoId";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(PersonOrderDto.class));
        query.setString("orderDate",boxBookInfo.getOrderDate()).setInteger("boxInfoId",boxBookInfo.getBoxInfoId());
        return (PersonOrderDto) query.uniqueResult();
    }

    @Override
    public List<PersonOrderDto> getBookInfoFromWeixin(String weixin) {
        String sql = "SELECT bb.orderDate AS orderDate,bt.name AS boxTypeName,bf.price AS price, bf.boxNo AS boxNo"
                +" ,cs.telephone AS telephone "
                +"FROM BoxBookInfo bb , BoxInfo bf,Customer cs,BoxType bt WHERE"
                +" bb.boxInfoId = bf.boxInfoId and bf.boxTypeId = bt.boxTypeId AND bb.customerId = cs.customerId and cs.weixin =:weixin ORDER BY bb.orderDate DESC ";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(PersonOrderDto.class));
        query.setString("weixin",weixin);
        return query.list();
    }
}
