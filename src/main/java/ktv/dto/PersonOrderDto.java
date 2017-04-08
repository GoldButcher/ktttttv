package ktv.dto;

/**
 * Created by admin on 2017/1/8.
 */
public class PersonOrderDto {
    private String orderDate;//预定时间
    private String boxTypeName;//包厢类型名
    private double price;//价格
    private String boxNo;//包厢号
    private String telephone;//手机号

    public PersonOrderDto() {}

    public PersonOrderDto(String orderDate, String boxTypeName, double price, String boxNo, String telephone) {
        this.orderDate = orderDate;
        this.boxTypeName = boxTypeName;
        this.price = price;
        this.boxNo = boxNo;
        this.telephone = telephone;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getBoxTypeName() {
        return boxTypeName;
    }

    public void setBoxTypeName(String boxTypeName) {
        this.boxTypeName = boxTypeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
