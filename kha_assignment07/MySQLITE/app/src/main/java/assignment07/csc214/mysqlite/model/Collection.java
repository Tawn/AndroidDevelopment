package assignment07.csc214.mysqlite.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Collection {

    private static Collection sCollection;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;
    private final List<FoodStock> mFoods;
    private final Map<UUID, FoodStock> mFoodMap;

    public Collection(Context context) {
        mContext = context.getApplicationContext();
        //Connect to database
        mDatabase = null;
        mFoods = new LinkedList<>();
        mFoodMap = new HashMap<>();

        // List of Foods
        addFood("Cherry", "Red", 5);
        addFood("Orange", "Blue", 5);

    }

    public void addFood(String name, String color, int weight) {
        FoodStock food = new FoodStock(name, color, weight);
        mFoodMap.put(food.getID(), food);

    }

    public static Collection get(Context context) {
        if(sCollection == null) {
            sCollection = new Collection(context);
        }
        return sCollection;
    }

    public List<FoodStock> getList() {
        List<FoodStock> list = new ArrayList<>();
        list.addAll(mFoodMap.values());
        return list;
    }

}
