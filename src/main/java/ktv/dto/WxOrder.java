package ktv.dto;

/**
 * Created by ycy on 2017/4/12.
 */
public class WxOrder {
    private String boxName;
    private int bookId;
    private String orderDate;
    private int typeId;

    public WxOrder() {
    }


    public WxOrder(String boxName, int bookId, String orderDate, int typeId) {
        this.boxName = boxName;
        this.bookId = bookId;
        this.orderDate = orderDate;
        this.typeId = typeId;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
