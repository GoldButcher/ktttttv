package ktv.dto;

/**
 * Created by admin on 2017/1/4.
 */
public class ListBoxDto {
    private Integer boxBookId;//订单号
    private String orderDate;//预定时间
    private Integer boxBookStatus;//预定状态 ：1未预定 2已预定 3已取消
    private Integer boxInfoId;//包厢主键
    private Integer payment;//付款方式
    private String boxNo;//包厢号
    private String boxName;//包厢名字
    private Integer boxStatus;//包厢状态：是否能被预定
    private String boxDescription;//包厢描述
    private String boxNotice;//注意事项
    private Integer boxTypeId;//包厢类别id
    private String boxTypeName;//包厢类别名
    private String boxTypeDescription;//包厢类别描述
    private Integer boxNum;
    private Integer leftBoxNum;
    private String telphone;
    public ListBoxDto() {}

    public ListBoxDto(Integer boxBookId, String orderDate, Integer boxBookStatus, Integer boxInfoId, Integer payment, String boxNo, String boxName, Integer boxStatus, String boxDescription, String boxNotice, Integer boxTypeId, String boxTypeName, String boxTypeDescription, Integer boxNum, Integer leftBoxNum, String telphone) {
        this.boxBookId = boxBookId;
        this.orderDate = orderDate;
        this.boxBookStatus = boxBookStatus;
        this.boxInfoId = boxInfoId;
        this.payment = payment;
        this.boxNo = boxNo;
        this.boxName = boxName;
        this.boxStatus = boxStatus;
        this.boxDescription = boxDescription;
        this.boxNotice = boxNotice;
        this.boxTypeId = boxTypeId;
        this.boxTypeName = boxTypeName;
        this.boxTypeDescription = boxTypeDescription;
        this.boxNum = boxNum;
        this.leftBoxNum = leftBoxNum;
        this.telphone = telphone;
    }

    public Integer getBoxBookId() {
        return boxBookId;
    }

    public void setBoxBookId(Integer boxBookId) {
        this.boxBookId = boxBookId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getBoxBookStatus() {
        return boxBookStatus;
    }

    public void setBoxBookStatus(Integer boxBookStatus) {
        this.boxBookStatus = boxBookStatus;
    }

    public Integer getBoxInfoId() {
        return boxInfoId;
    }

    public void setBoxInfoId(Integer boxInfoId) {
        this.boxInfoId = boxInfoId;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
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

    public Integer getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(Integer boxStatus) {
        this.boxStatus = boxStatus;
    }

    public String getBoxDescription() {
        return boxDescription;
    }

    public void setBoxDescription(String boxDescription) {
        this.boxDescription = boxDescription;
    }

    public String getBoxNotice() {
        return boxNotice;
    }

    public void setBoxNotice(String boxNotice) {
        this.boxNotice = boxNotice;
    }

    public Integer getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Integer boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public String getBoxTypeName() {
        return boxTypeName;
    }

    public void setBoxTypeName(String boxTypeName) {
        this.boxTypeName = boxTypeName;
    }

    public String getBoxTypeDescription() {
        return boxTypeDescription;
    }

    public void setBoxTypeDescription(String boxTypeDescription) {
        this.boxTypeDescription = boxTypeDescription;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Integer getLeftBoxNum() {
        return leftBoxNum;
    }

    public void setLeftBoxNum(Integer leftBoxNum) {
        this.leftBoxNum = leftBoxNum;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
