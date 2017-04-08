package ktv.dto;

import ktv.model.Customer;

/**
 * Created by admin on 2017/1/7.
 */
public class CustomerInfoDto {
    private String weixin;//用户微信号
    private String telephone;//用户手机号
    private String orderDate;//预定时间

    public CustomerInfoDto(){}

    public CustomerInfoDto(String weixin, String telephone, String orderDate) {
        this.weixin = weixin;
        this.telephone = telephone;
        this.orderDate = orderDate;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
