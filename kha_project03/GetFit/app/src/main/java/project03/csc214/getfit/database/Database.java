package project03.csc214.getfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.Routine;
import project03.csc214.getfit.model.Workout;

/**
 * Created by Tkha on 6/27/17.
 */

public class Database {

    private static Database sProgressDatabase;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;

    // Days
    private final List<Day> mDays; // Contains list of Routines

    public Database(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DatabaseHelper(mContext).getWritableDatabase();
        mDays = new ArrayList<>();

    }

    public static synchronized Database get(Context context) {
        if(sProgressDatabase == null) {
            sProgressDatabase = new Database(context);
        }
        return sProgressDatabase;
    }

    // (DAY) GET ALL DAYS IN 1 WEEK
    public List<Day> getDays() {
        mDays.clear();
        DatabaseCursorWrapper wrapper = queryUser(null, null);

        try {
            wrapper.moveToFirst();
            while(wrapper.isAfterLast() == false) {
                Day day = wrapper.getDays();
                mDays.add(day);
                wrapper.moveToNext();
            }
        }
        finally {
            wrapper.close();
        }

        return mDays;
    }


    private DatabaseCursorWrapper queryUser(String where, String[] args) {
        Cursor cursor = mDatabase.query(
                Schema.ProgressTable.NAME, // table name
                null,                          // which columns; null for all
                where,                         // where clause, e.g. id=?
                args,                          // where arguments
                null,                          // group by
                null,                          // having
                null                           // order by
        );

        return new DatabaseCursorWrapper(cursor);
    }

    public void addDay(Day day) {
        ContentValues values = getContentvalues(day);
        mDatabase.insert(Schema.ProgressTable.NAME, null, values);
    }

    private static ContentValues getContentvalues(Day day) {
        ContentValues values = new ContentValues();
        values.put(Schema.ProgressTable.Cols.DAY, day.getDayNumber());
        values.put(Schema.ProgressTable.Cols.ROUTINE, day.getRoutine());
        values.put(Schema.ProgressTable.Cols.NOTE, day.getNote());
        return values;
    }

}
