package ktv.dao.impl;

import ktv.dao.IBoxBookInfoDao;
import ktv.dto.ListBoxDto;
import ktv.dto.PersonOrderDto;
import ktv.dto.SingleBookBoxById;
import ktv.dto.WxOrder;
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
        String hql = "select bb from  BoxInfo bf ,BoxBookInfo bb where bf.boxInfoId = bb.boxInfoId " +
                " and bf.boxNo=:boxNo and bb.orderDate=:orderDate";
        Query query = getSession().createQuery(hql);
        query.setString("boxNo", boxNo).setString("orderDate", date);
        return (BoxBookInfo) query.uniqueResult();
    }

    @Override
    public PersonOrderDto getBooxInfo4Order(BoxBookInfo boxBookInfo) {
        String sql = "SELECT bb.orderDate AS orderDate,bt.name AS boxTypeName,bf.price AS price, bf.boxNo AS boxNo"
                + " ,cs.telephone AS telephone "
                + "FROM BoxBookInfo bb , BoxInfo bf,Customer cs,BoxType bt WHERE"
                + " bb.boxInfoId = bf.boxInfoId AND bf.boxTypeId = bt.boxTypeId AND bb.customerId = cs.customerId AND"
                + " bb.orderDate = :orderDate AND bb.boxInfoId = :boxInfoId";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(PersonOrderDto.class));
        query.setString("orderDate", boxBookInfo.getOrderDate()).setInteger("boxInfoId", boxBookInfo.getBoxInfoId());
        return (PersonOrderDto) query.uniqueResult();
    }

    @Override
    public List<PersonOrderDto> getBookInfoFromWeixin(String weixin) {
        String sql = "SELECT bb.orderDate AS orderDate,bt.name AS boxTypeName,bf.price AS price, bf.boxNo AS boxNo"
                + " ,cs.telephone AS telephone"
                + "FROM BoxBookInfo bb , BoxInfo bf,Customer cs,BoxType bt WHERE"
                + " bb.boxInfoId = bf.boxInfoId AND bf.boxTypeId = bt.boxTypeId AND bb.customerId = cs.customerId AND cs.weixin =:weixin ORDER BY bb.orderDate DESC ";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(PersonOrderDto.class));
        query.setString("weixin", weixin);
        return query.list();
    }

    @Override
    public List<WxOrder> getOrderByWx(String wx) {
        String sql = "SELECT BoxInfo.boxName AS boxName,BoxBookInfo.id AS bookId,BoxBookInfo.orderDate AS date ,BoxInfo.boxTypeId AS typeId FROM BoxBookInfo,Customer,BoxInfo WHERE BoxBookInfo.customerId=Customer.customerId AND Customer.weixin=:wx AND BoxInfo.boxInfoId=BoxBookInfo.boxInfoId AND BoxBookInfo.payment = 1 ORDER BY BoxBookInfo.id DESC";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(WxOrder.class));
        query.setString("wx", wx);
        return query.list();

    }

    @Override
    public SingleBookBoxById getSingleBookBoxInfo(int id) {
        String sql = "SELECT\n" +
                "  Customer.telephone,\n" +
                "  BoxBookInfo.orderDate,\n" +
                "  BoxInfo.boxTypeId,\n" +
                "  BoxInfo.boxName,\n" +
                "  BoxType.price\n" +
                "FROM Customer, BoxBookInfo, BoxInfo, BoxType\n" +
                "WHERE\n" +
                "  Customer.customerId = BoxBookInfo.customerId AND BoxBookInfo.id =:id AND BoxInfo.boxInfoId = BoxBookInfo.boxInfoId\n" +
                "  AND BoxInfo.boxTypeId = BoxType.boxTypeId";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(SingleBookBoxById.class));
        query.setString("id", String.valueOf(id));
        return (SingleBookBoxById) query.list().get(0);
    }
}
