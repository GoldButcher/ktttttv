package ktv.service.impl;

import ktv.dao.IBoxInfoDao;
import ktv.dto.BoxInfoDto;
import ktv.dto.ListBoxDto;
import ktv.model.BoxInfo;
import ktv.model.BoxType;
import ktv.service.IBoxBookInfoService;
import ktv.service.IBoxInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class BoxInfoServiceImpl extends AbstractServiceimpl<Integer,BoxInfo> implements IBoxInfoService {
    @Resource
    private IBoxInfoDao boxInfoDao;

    @Resource
    public void setBoxInfoDao(IBoxInfoDao boxInfoDao) {
        super.setAbstractDao(boxInfoDao);
    }

    @Override
    public BoxInfoDto getBoxInfo(int boxInfoId) {

        return boxInfoDao.getBoxInfo(boxInfoId);
    }

    @Override
    public List<ListBoxDto> getBoxLists(int typeId, String date, int payStatus, int pageNum) {
        return boxInfoDao.getBoxLists(typeId,date,payStatus,pageNum);
    }

    @Override
    public List<BoxInfoDto> getAllBoxListsByTypeId(int typeid) {
        return boxInfoDao.getAllBoxListsByTypeId(typeid);
    }

    @Override
    public List<ListBoxDto> getAllBoxListsByTelephone(String telephone) {
        return boxInfoDao.getAllBoxListsByTelephone(telephone);
    }

    @Override
    public BoxInfo getEmptyBox(String date, int typeId) {
        return boxInfoDao.getEmptyBox(date,typeId);
    }

}
