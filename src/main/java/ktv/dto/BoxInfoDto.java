package ktv.dto;

/**
 * Created by admin on 2017/1/3.
 */
public class BoxInfoDto {
    private Integer boxInfoId;
    private String boxNo;
    private String boxName;
    private Integer status;
    private String boxInfoDescription;
    private String notice;
    private Integer boxTypeId;
    private String name;
    private String boxTypeDescription;
    private double price;

    public BoxInfoDto() {
    }

    public BoxInfoDto(Integer boxInfoId, String boxNo, String boxName, Integer status, String boxInfoDescription, String notice, Integer boxTypeId, String name, String boxTypeDescription, double price) {
        this.boxInfoId = boxInfoId;
        this.boxNo = boxNo;
        this.boxName = boxName;
        this.status = status;
        this.boxInfoDescription = boxInfoDescription;
        this.notice = notice;
        this.boxTypeId = boxTypeId;
        this.name = name;
        this.boxTypeDescription = boxTypeDescription;
        this.price = price;
    }

    public Integer getBoxInfoId() {
        return boxInfoId;
    }

    public void setBoxInfoId(Integer boxInfoId) {
        this.boxInfoId = boxInfoId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBoxInfoDescription() {
        return boxInfoDescription;
    }

    public void setBoxInfoDescription(String boxInfoDescription) {
        this.boxInfoDescription = boxInfoDescription;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Integer getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Integer boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoxTypeDescription() {
        return boxTypeDescription;
    }

    public void setBoxTypeDescription(String boxTypeDescription) {
        this.boxTypeDescription = boxTypeDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
