package project02.csc214.myinstagram.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Tkha on 6/18/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "UserDatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, Schema.DATABSE_NAME, null, Schema.VERSION);
        Log.i(TAG, "UserDatabaseHelper: Constructor invoked");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate: Tables Created");

        db.execSQL("create table " + Schema.UserTable.NAME
                + "(_id integer primary key autoincrement, "
                + Schema.UserTable.Cols.USERNAME + ", "
                + Schema.UserTable.Cols.PASSWORD + ", "
                + Schema.UserTable.Cols.ID + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
