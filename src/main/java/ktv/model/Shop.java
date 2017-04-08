package ktv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by evan on 16-12-21.
 */
@Entity
public class Shop {
    //primary key

    private Integer id;

    //the No. of the shop
    private String shopNO;

    //the location of the shop
    private String location;

    //the fix-line phone of the shop
    private String fixLinePhone;

    //the weixin of the shop
    private String weixin;

    //the brief-description of the shop
    private String description;

    //about about shop information
    private String aboutUs;

    private String companyName;

    public Shop() {
    }

    public Shop(Integer id, String shopNO, String location, String fixLinePhone, String weixin, String description, String aboutUs, String companyName) {
        this.id = id;
        this.shopNO = shopNO;
        this.location = location;
        this.fixLinePhone = fixLinePhone;
        this.weixin = weixin;
        this.description = description;
        this.aboutUs = aboutUs;
        this.companyName = companyName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShopNO() {
        return shopNO;
    }

    public void setShopNO(String shopNO) {
        this.shopNO = shopNO;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFixLinePhone() {
        return fixLinePhone;
    }

    public void setFixLinePhone(String fixLinePhone) {
        this.fixLinePhone = fixLinePhone;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
