package ktv.controller;

import ktv.service.IShopService;
import ktv.util.SignUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by evan on 16-12-20.
 */
@RestController
public class MainController {
    @Resource
    private IShopService shopService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        if(session.getAttribute("userId")!=null)
        return new ModelAndView("redirect:/desktopEnd/index.html");
        return new ModelAndView("redirect:/desktopEnd/login.html");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get(HttpServletRequest request) {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String post(HttpServletRequest request)
    {
        String response = shopService.responseMsg(request);
        return response;
    }
}
