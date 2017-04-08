package ktv.service;

import ktv.model.Manager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2016/12/25.
 */
public interface IManagerService extends AbstractService<Integer,Manager>{
    Boolean doLogin(HttpServletRequest request,Manager manager);
}
