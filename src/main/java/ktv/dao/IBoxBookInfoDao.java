package ktv.dao;

import ktv.dto.PersonOrderDto;
import ktv.dto.SingleBookBoxById;
import ktv.model.BoxBookInfo;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface IBoxBookInfoDao extends AbstractDao<Integer,BoxBookInfo>{
    BoxBookInfo getOrder(String boxNo,String date);

    PersonOrderDto getBooxInfo4Order(BoxBookInfo boxBookInfo);

    List<PersonOrderDto> getBookInfoFromWeixin(String weixin);

    List getOrderByWx(String wx);

    SingleBookBoxById getSingleBookBoxInfo(int id);
}
