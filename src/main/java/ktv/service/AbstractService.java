package ktv.service;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface AbstractService<PK extends Serializable,T> {
    T getByKey(PK key);
    T getByProperties(String propertiesName,String properties);
    PK sava(T entity);
    void update(T entity);
    void delete(T entity);
    Criteria createEntityCriteria();
    List<T> getAll();
    Long getTotalCount();

}
