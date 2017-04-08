package ktv.service.impl;

import ktv.dao.AbstractDao;
import ktv.dao.ICustomerDao;
import ktv.dao.IManagerDao;
import ktv.model.Manager;
import ktv.service.IManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class ManagerServiceImpl extends AbstractServiceimpl<Integer,Manager> implements IManagerService{
    @Resource
    private IManagerDao managerDao;

    @Resource
    public void setManagerDao(IManagerDao managerDao) {
        super.setAbstractDao(managerDao);
    }

    @Override
    public Boolean doLogin(HttpServletRequest request,Manager manager) {
        Manager verifyManager = managerDao.getByProperties("username",manager.getUsername());
        String password = DigestUtils.md5DigestAsHex(manager.getPassword().trim().getBytes());
        if(verifyManager != null)
        {
            if("" != manager.getPassword().trim() && password.equals(verifyManager.getPassword()))
            {
                request.getSession().setAttribute("userId",verifyManager.getId());
                return true;
            }
        }
        return false;
    }
}
