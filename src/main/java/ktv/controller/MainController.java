package ktv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by evan on 16-12-20.
 */
@RestController
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        if(session.getAttribute("userId")!=null)
        return new ModelAndView("redirect:/desktopEnd/index.html");
        return new ModelAndView("redirect:/desktopEnd/login.html");
    }
}
