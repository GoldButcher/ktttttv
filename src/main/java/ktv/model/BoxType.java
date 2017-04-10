package ktv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by evam on 16-12-21.
 */
@Entity
public class BoxType {
    private Integer boxTypeId;
    private String name;
    private String description;
    private int boxNum;
    private int leftBoxNum;
    private double price;
    public BoxType() {
    }

    public BoxType(String name, String description, int boxNum, int leftBoxNum,double price) {
        this.name = name;
        this.description = description;
        this.boxNum = boxNum;
        this.leftBoxNum = leftBoxNum;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBoxTypeId() {return boxTypeId;}

    public void setBoxTypeId(Integer boxTypeId) {this.boxTypeId = boxTypeId;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }

    public int getLeftBoxNum() {
        return leftBoxNum;
    }

    public void setLeftBoxNum(int leftBoxNum) {
        this.leftBoxNum = leftBoxNum;
    }
}
