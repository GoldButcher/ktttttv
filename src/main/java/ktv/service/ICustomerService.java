package ktv.service;

import ktv.dto.CommonResponseDto;
import ktv.dto.CustomerInfoDto;
import ktv.model.Customer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 2016/12/25.
 */
public interface ICustomerService extends AbstractService<Integer,Customer>{
    List<CustomerInfoDto> getAllCustomerByDate(String date);
    //CommonResponseDto getCheck(String mobile, HttpSession session) throws Exception;
    //public CommonResponseDto check(String str,HttpSession session);

    public ModelAndView customerLogin(HttpServletRequest request);
}
