package assignment07.csc214.mysqlight.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import assignment07.csc214.instagram.database.UserDbSchema.UserTable;

/**
 * Created by Tkha on 6/17/17.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public UserDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UserDbSchema.DATABSE_NAME
                + UserTable.Cols.ID);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
