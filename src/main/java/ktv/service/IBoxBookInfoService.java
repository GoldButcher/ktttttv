package ktv.service;

import ktv.dto.*;
import ktv.model.BoxBookInfo;


import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface IBoxBookInfoService extends AbstractService<Integer,BoxBookInfo>{

    CommonResponseDto bookBox(String date,String boxNo,String weixin,String telephone,int payment,String username,String description);

    CommonResponseDto cancelBookBox(String date,String boxNo,String telephone);

    List<PersonOrderDto> getBookInfoFromWeixin(String weixin);

    CommonResponseDto payOrder(String date,String boxNo,int payment);

    List<WxOrder> getOrderByWx(String wx);

    SingleBookBoxById getSingleBookBoxInfo(int id);
}
