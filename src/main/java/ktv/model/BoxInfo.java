package ktv.model;

import javax.persistence.*;

/**
 * Created by evam on 16-12-21.
 */
@Entity
public class BoxInfo {
    private Integer boxInfoId;
    private String boxNo;
    private String boxName;
    private int status;
    private String description;
    private String notice;
    private Integer boxTypeId;
    private double price;
    public BoxInfo() {

    }

    public BoxInfo(Integer boxInfoId, String boxNo, String boxName, int status, String description, String notice, Integer boxTypeId, double price) {
        this.boxInfoId = boxInfoId;
        this.boxNo = boxNo;
        this.boxName = boxName;
        this.status = status;
        this.description = description;
        this.notice = notice;
        this.boxTypeId = boxTypeId;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBoxInfoId() {return boxInfoId;}

    public void setBoxInfoId(Integer boxInfoId) {this.boxInfoId = boxInfoId;}

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

    @JoinColumn(name = "boxTypeId")
    public Integer getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Integer boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
