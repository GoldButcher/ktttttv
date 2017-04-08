package ktv.service.impl;

import ktv.dao.AbstractDao;
import ktv.service.AbstractService;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
public class AbstractServiceimpl<PK extends Serializable,T> implements AbstractService<PK,T>{

    private AbstractDao<PK, T> abstractDao;

    public AbstractDao<PK, T> getAbstractDao() {
        return abstractDao;
    }

    public void setAbstractDao(AbstractDao<PK, T> abstractDao) {
        this.abstractDao = abstractDao;
    }

    @Override
    public T getByKey(PK key) {
        return abstractDao.getByKey(key);
    }

    @Override
    public T getByProperties(String propertiesName, String properties) {
        return abstractDao.getByProperties(propertiesName,properties);
    }

    @Override
    public void update(T entity) {
        abstractDao.update(entity);
    }

    @Override
    public PK sava(T entity) {
        return abstractDao.sava(entity);
    }

    @Override
    public void delete(T entity) {
        abstractDao.delete(entity);
    }

    @Override
    public Criteria createEntityCriteria() {
        return abstractDao.createEntityCriteria();
    }

    @Override
    public List<T> getAll() {
        return abstractDao.getAll();
    }

    @Override
    public Long getTotalCount() {
        return abstractDao.getTotalCount();
    }
}
