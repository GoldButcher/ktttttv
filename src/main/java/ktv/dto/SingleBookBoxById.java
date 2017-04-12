package ktv.dto;

/**
 * Created by ycy on 2017/4/12.
 */
public class SingleBookBoxById {
    private String tel;

    private String dat;

    private String boxNo;

    private String boxName;

    private double price;

    public SingleBookBoxById() {
    }

    public SingleBookBoxById(String tel, String dat, String boxNo, String boxName, double price) {
        this.tel = tel;
        this.dat = dat;
        this.boxNo = boxNo;
        this.boxName = boxName;
        this.price = price;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
