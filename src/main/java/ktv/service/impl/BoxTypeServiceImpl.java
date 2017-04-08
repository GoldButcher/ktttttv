package ktv.service.impl;

import ktv.dao.IBoxTypeDao;
import ktv.model.BoxType;
import ktv.service.IBoxTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class BoxTypeServiceImpl extends AbstractServiceimpl<Integer,BoxType> implements IBoxTypeService{
    @Resource
    private IBoxTypeDao boxTypeDao;

    @Resource
    public void setBoxTypeDao(IBoxTypeDao boxTypeDao) {
        super.setAbstractDao(boxTypeDao);
    }

}
