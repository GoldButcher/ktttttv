package ktv.service.impl;

import ktv.dao.AbstractDao;
import ktv.dao.IBoxBookInfoDao;
import ktv.dao.IBoxInfoDao;
import ktv.dao.ICustomerDao;
import ktv.dto.CommonResponseDto;
import ktv.dto.ListBoxDto;
import ktv.dto.PersonOrderDto;
import ktv.model.BoxBookInfo;
import ktv.model.BoxInfo;
import ktv.model.Customer;
import ktv.service.IBoxBookInfoService;
import ktv.util.CommonResponseUtil;
import org.springframework.data.geo.Box;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Created by admin on 2016/12/25.
 */
@Transactional
@Service
public class BoxBookInfoServiceImpl extends AbstractServiceimpl<Integer, BoxBookInfo> implements IBoxBookInfoService {
    @Resource
    private IBoxBookInfoDao boxBookInfoDao;

    @Resource
    private IBoxInfoDao boxInfoDao;

    @Resource
    private ICustomerDao customerDao;

    @Resource
    public void setBoxBookInfoDao(IBoxBookInfoDao boxBookInfoDao) {
        super.setAbstractDao(boxBookInfoDao);
    }

    @Override
    public CommonResponseDto bookBox(String date, String boxNo, String weixin, String telephone, int payment, String username, String description) {

        BoxInfo boxInfo = boxInfoDao.getByProperties("boxNo", boxNo);
        BoxBookInfo boxBookInfo = boxBookInfoDao.getOrder(boxNo, date);
        if (boxBookInfo != null) return CommonResponseUtil.errorWithObj("该包厢已经被预定！");
        Customer customer = customerDao.getByProperties("telephone", telephone);
        int customerId = 0;
        if (customer == null) {
            customer = new Customer();
            customer.setTelephone(telephone);
            if (!Objects.equals(weixin, ""))
                customer.setWeixin(weixin);
            customerId = customerDao.sava(customer);
        } else {
            if (!Objects.equals(weixin, ""))
                customer.setWeixin(weixin);
            customerId = customer.getCustomerId();
            customerDao.update(customer);
        }
        boxBookInfo = new BoxBookInfo();
        boxBookInfo.setStatus(2);
        boxBookInfo.setBoxInfoId(boxInfo.getBoxInfoId());
        boxBookInfo.setCustomerId(customerId);
        boxBookInfo.setOrderDate(date);
        boxBookInfo.setPayment(payment);
        boxBookInfo.setUserName(username);
        boxBookInfo.setDescription(description);
        if (0 != boxBookInfoDao.sava(boxBookInfo))
            return CommonResponseUtil.successWithNull();
        return CommonResponseUtil.errorWithObj("系统错误,请稍后再试");
    }

    @Override
    public CommonResponseDto cancelBookBox(String date, String boxNo, String telephone) {
        BoxBookInfo boxBookInfo = boxBookInfoDao.getOrder(boxNo, date);
        if (boxBookInfo == null) return CommonResponseUtil.errorWithObj("请确认该订单是否存在!");
        Customer customer = customerDao.getByKey(boxBookInfo.getCustomerId());
        if (!customer.getTelephone().equals(telephone.trim())) return CommonResponseUtil.errorWithObj("请填写正确的预留手机号!");

        boxBookInfoDao.delete(boxBookInfo);
        return CommonResponseUtil.successWithNull();
    }

    @Override
    public List<PersonOrderDto> getBookInfoFromWeixin(String weixin) {
        return boxBookInfoDao.getBookInfoFromWeixin(weixin);
    }

    @Override
    public CommonResponseDto payOrder(String date, String boxNo, int payment) {
        BoxBookInfo boxBookInfo = boxBookInfoDao.getOrder(boxNo, date);
        if (boxBookInfo == null)
            return CommonResponseUtil.errorWithObj("支付失败请稍后再试！");
        boxBookInfo.setPayment(payment);
        boxBookInfoDao.update(boxBookInfo);
        PersonOrderDto personOrderDto = boxBookInfoDao.getBooxInfo4Order(boxBookInfo);
        return CommonResponseUtil.successWithObj(personOrderDto);
    }
}
