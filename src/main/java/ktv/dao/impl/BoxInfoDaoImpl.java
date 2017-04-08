package ktv.dao.impl;

import ktv.dao.IBoxInfoDao;
import ktv.dto.BoxInfoDto;
import ktv.dto.ListBoxDto;
import ktv.model.BoxInfo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Repository
public class BoxInfoDaoImpl extends AbstractDaoImpl<Integer, BoxInfo> implements IBoxInfoDao {

    @Override
    public List<ListBoxDto> getBoxLists(int typeId, String date, int payStatus, int pageNum) {
        String sql = "SELECT bb.id AS boxBookId ,bb.orderDate AS orderDate ,bb.status AS boxBookStatus,"
                +"bb.boxInfoId AS boxInfoId , bb.payment AS payment,bf.boxNo AS boxNo,bf.boxName AS boxName,"
                +"bf.status AS boxStatus,bf.description AS boxDescription,bf.notice AS boxNotice,"
                +"bf.boxTypeId AS boxTypeId, bt.name AS boxTypeName,bt.description AS boxTypeDescription,bt.boxNum AS boxNum,"
                +"bt.leftBoxNum AS leftBoxNum ,cs.telephone AS telphone"
        +"  FROM ((BoxInfo bf LEFT OUTER JOIN BoxType bt ON bf.boxTypeId = bt.boxTypeId)"
                + " LEFT OUTER JOIN BoxBookInfo bb ON bf.boxInfoId =bb.boxInfoId)LEFT OUTER JOIN Customer cs ON "+
                "cs.customerId = bb.customerId WHERE "+
                "bf.boxTypeId =:boxTypeId and bb.orderDate=:orderDate and bb.status =:payStatus ";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ListBoxDto.class));
        query.setInteger("boxTypeId",typeId).setString("orderDate",date).setInteger("payStatus",payStatus);
        return query.list();
    }

    @Override
    public List<BoxInfoDto> getAllBoxListsByTypeId(int typeid) {

        String sql = "select bf.boxInfoId AS boxInfoId,bf.boxNo AS boxNo , bf.boxName AS boxName,bf.status AS status,"
                + "bf.description AS boxInfoDescription,bf.notice AS notice,bt.boxTypeId AS boxTypeId,"
                + "bt.name AS name,bt.description AS boxTypeDescription"
                + " from (BoxInfo bf LEFT OUTER JOIN BoxType bt ON bf.boxTypeId = bt.boxTypeId) "
                + " WHERE bt.boxTypeId =:boxTypeId";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(BoxInfoDto.class));
        query.setInteger("boxTypeId",typeid);
        return query.list();
    }

    @Override
    public List<ListBoxDto> getAllBoxListsByTelephone(String telephone) {
        String sql = "SELECT bb.id AS boxBookId ,bb.orderDate AS orderDate ,bb.status AS boxBookStatus,"
                +"bb.boxInfoId AS boxInfoId , bb.payment AS payment,bf.boxNo AS boxNo,bf.boxName AS boxName,"
                +"bf.status AS boxStatus,bf.description AS boxDescription,bf.notice AS boxNotice,"
                +"bf.boxTypeId AS boxTypeId, bt.name AS boxTypeName,bt.description AS boxTypeDescription,bt.boxNum AS boxNum,"
                +"bt.leftBoxNum AS leftBoxNum ,cs.telephone AS telphone"
                +"  FROM ((BoxInfo bf LEFT OUTER JOIN BoxType bt ON bf.boxTypeId = bt.boxTypeId)"
                + " LEFT OUTER JOIN BoxBookInfo bb ON bf.boxInfoId =bb.boxInfoId)LEFT OUTER JOIN Customer cs ON "+
                "cs.customerId = bb.customerId WHERE "+
                "cs.telephone = :telephone";
        Query query = getSession().createSQLQuery(sql).setString("telephone",telephone);
        return query.list();
    }

    @Override
    public BoxInfo getEmptyBox(String date, int typeId) {
        String sql = "SELECT * From BoxInfo bf where bf.boxInfoId not in (SELECT boxInfoId from BoxBookInfo bb where bb.orderDate = :orderDate) AND bf.boxTypeId =:boxTypeId";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(BoxInfo.class));
        query.setString("orderDate",date).setInteger("boxTypeId",typeId);
        List<BoxInfo> boxInf = query.list();
        return boxInf.get(0);
    }

    @Override
    public BoxInfoDto getBoxInfo(int boxInfoId) {
        String sql = "select bf.boxInfoId AS boxInfoId,bf.boxNo AS boxNo , bf.boxName AS boxName,bf.status AS status,"
                + "bf.description AS boxInfoDescription,bf.notice AS notice,bt.boxTypeId AS boxTypeId,"
                + "bt.name AS name,bt.description AS boxTypeDescription"
                + " from (BoxInfo bf LEFT OUTER JOIN BoxType bt ON bf.boxTypeId = bt.boxTypeId)"
                + " WHERE bf.boxInfoId =:boxInfoId";
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(BoxInfoDto.class));
        query.setInteger("boxInfoId",boxInfoId);
        return (BoxInfoDto) query.uniqueResult();
    }
}
