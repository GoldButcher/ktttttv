package ktv.service;

import ktv.dto.CommonResponseDto;
import ktv.dto.ListBoxDto;
import ktv.dto.PersonOrderDto;
import ktv.model.BoxBookInfo;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface IBoxBookInfoService extends AbstractService<Integer,BoxBookInfo>{

    CommonResponseDto bookBox(String date,String boxNo,String weixin,String telephone,int payment);

    CommonResponseDto cancelBookBox(String date,String boxNo,String telephone);

    List<PersonOrderDto> getBookInfoFromWeixin(String weixin);

    CommonResponseDto payOrder(String date,String boxNo,int payment);
}
