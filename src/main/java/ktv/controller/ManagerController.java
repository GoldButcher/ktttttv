package ktv.controller;

import ktv.dto.CommonResponseDto;
import ktv.model.Manager;
import ktv.service.IManagerService;
import ktv.util.CommonResponseUtil;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 2016/12/26.
 */
@RestController
public class ManagerController {
    @Resource
    private IManagerService managerService;

    //初始化manager
    @PostConstruct
    public void initManager()
    {
        if(managerService.getTotalCount()==0)
        {
            Manager manager = new Manager();
            manager.setUsername("admin");
            manager.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
            managerService.sava(manager);
        }
    }
    /**
     * @title:管理员登陆验证
     * @user:clj
     * @return:ktv.dto.CommonResponseDto
     * @date:2016/12/29 22:19
     **/
    @RequestMapping(value="/dologin")
    public CommonResponseDto doLogin(HttpServletRequest request, Manager manager)
    {
//        Assert.notNull(manager);
        Boolean result = managerService.doLogin(request,manager);
        if(result)
        {
            return CommonResponseUtil.successWithNull();
        }else{
            return CommonResponseUtil.errorWithObj("帐号名或密码错误");
        }
    }
    /**
     * @title:管理员注销
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2016/12/29 22:19
     **/
    @RequestMapping(value = "/logout")
    public CommonResponseDto logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:管理员修改密码
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/3 3:00
     **/
    @RequestMapping(value = "editPassowrd")
    public CommonResponseDto editPassword(String oldPass,String newPass)
    {
        List<Manager> managers = managerService.getAll();
        Manager manager = managers.get(0);
        if(manager.getPassword().equals(DigestUtils.md5Digest(oldPass.getBytes())))
        {
            manager.setPassword(DigestUtils.md5DigestAsHex(newPass.getBytes()));
            managerService.sava(manager);
            return CommonResponseUtil.successWithNull();
        }else{
            return CommonResponseUtil.errorWithObj("原密码不正确");
        }
    }
}
