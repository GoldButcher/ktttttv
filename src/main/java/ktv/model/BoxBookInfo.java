package ktv.model;

import javax.persistence.*;

/**
 * Created by evam on 16-12-21.
 */
@Entity
public class BoxBookInfo {
    private Integer id;
    private String orderDate;
    private int status;
    private Integer customerId;
    private Integer boxInfoId;
    private int payment;//付款方式 1.未支付 2.微信 3.现金 4.刷卡

    public BoxBookInfo() {}

    public BoxBookInfo(String orderDate, int status, Integer customerId, int boxInfoId, int payment) {
        this.orderDate = orderDate;
        this.status = status;
        this.customerId = customerId;
        this.boxInfoId = boxInfoId;
        this.payment = payment;
    }

    public String getOrderDate() {return orderDate;}

    public void setOrderDate(String orderDate) {this.orderDate = orderDate;}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "customerId")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @JoinColumn(name = "boxInfoId")
    public Integer getBoxInfoId() {
        return boxInfoId;
    }

    public void setBoxInfoId(Integer boxInfoId) {
        this.boxInfoId = boxInfoId;
    }


    public int getPayment() {return payment;}

    public void setPayment(int payment) {this.payment = payment;}
}
