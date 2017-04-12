package ktv.dto;

/**
 * Created by ycy on 2017/4/12.
 */
public class SingleBookBoxById {
    private String tel;

    private String dat;

    private int type;

    private String name;

    private String price;

    public SingleBookBoxById() {
    }

    public SingleBookBoxById(String tel, String dat, int type, String name, String price) {
        this.tel = tel;
        this.dat = dat;
        this.type = type;
        this.name = name;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
