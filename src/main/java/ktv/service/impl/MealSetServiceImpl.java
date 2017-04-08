package ktv.service.impl;

import ktv.dao.AbstractDao;
import ktv.dao.IMealSetDao;
import ktv.model.MealSet;
import ktv.service.IMealSetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class MealSetServiceImpl extends AbstractServiceimpl<Integer,MealSet> implements IMealSetService{
    @Resource
    private IMealSetDao mealSetDao;

    @Resource
    public void setMealSetDao(IMealSetDao mealSetDao) {
        super.setAbstractDao(mealSetDao);
    }
}
