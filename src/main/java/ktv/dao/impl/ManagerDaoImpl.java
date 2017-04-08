package ktv.dao.impl;

import ktv.dao.IManagerDao;
import ktv.model.Manager;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2016/12/25.
 */
@Repository
public class ManagerDaoImpl extends AbstractDaoImpl<Integer, Manager> implements IManagerDao {
}
