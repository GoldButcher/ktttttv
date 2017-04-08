package ktv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by evam on 16-12-21.
 */
@Entity
public class Customer {
    private Integer customerId;
    private String weixin;
    private String telephone;

    public Customer() {}

    public Customer(String weixin, String telephone) {
        this.weixin = weixin;
        this.telephone = telephone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCustomerId() {return customerId;}

    public void setCustomerId(Integer customerId) {this.customerId = customerId;}

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
}
