package ktv.dao;

import ktv.dto.BoxInfoDto;
import ktv.dto.ListBoxDto;
import ktv.model.BoxInfo;

import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface IBoxInfoDao extends AbstractDao<Integer, BoxInfo> {
    BoxInfoDto getBoxInfo(int boxInfoId);

    List<ListBoxDto> getBoxLists(int typeId, String date, int payStatus, int pageNum);

    List<BoxInfoDto> getAllBoxListsByTypeId(int typeid);

    List<ListBoxDto> getAllBoxListsByTelephone(String telephone);

    BoxInfo getEmptyBox(String date,int typeId);

}
