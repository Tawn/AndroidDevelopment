package assignment07.csc214.mysqlite.model;

import java.util.UUID;

/**
 * Created by Tkha on 6/16/17.
 */

public class FoodStock {

    private String mName;
    private String mColor;
    private int mWeight;
    private UUID mID;

    public FoodStock(String name, String color, int weight) {
        mName = name;
        mColor = color;
        mWeight = weight;
        mID = UUID.randomUUID();
    }

    public String getName() {
        return mName;
    }

    public String getColor() {
        return mColor;
    }

    public int getWeight() {
        return mWeight;
    }

    public UUID getID() {
        return getID();
    }

}
