package ktv.model;

import javax.persistence.*;

/**
 * Created by evan on 2016/12/23.
 */
@Entity
public class MealSet {
    private Integer mealSetId;
    private Integer boxTypeId;
    private double price;
    private int dateTime;

    public MealSet(){}

    public MealSet(int boxTypeId, double price, int dateTime) {
        this.boxTypeId = boxTypeId;
        this.price = price;
        this.dateTime = dateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMealSetId() {return mealSetId;}

    public void setMealSetId(Integer mealSetId) {this.mealSetId = mealSetId;}

    @JoinColumn(name = "boxTypeId")
    public Integer getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Integer boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }
}
