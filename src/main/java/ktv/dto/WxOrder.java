package ktv.dto;

/**
 * Created by ycy on 2017/4/12.
 */
public class WxOrder {
    private String boxName;
    private int bookId;
    private String date;
    private int typeId;

    public WxOrder() {
    }

    public WxOrder(String boxName, int bookId, String date, int typeId) {
        this.boxName = boxName;
        this.bookId = bookId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
