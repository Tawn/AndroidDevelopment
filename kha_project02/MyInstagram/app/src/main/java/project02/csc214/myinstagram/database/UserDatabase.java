package project02.csc214.myinstagram.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import project02.csc214.myinstagram.model.User;

/**
 * Created by Tkha on 6/18/17.
 */

public class UserDatabase {
    private static UserDatabase sUserDatabase;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;
    private final List<User> mUsers;
    private final List<String> mUsernames;
    private final Map<String,String> mUserMap;


    private UserDatabase(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DatabaseHelper(mContext).getWritableDatabase();
        mUsers = new LinkedList<>();
        mUsernames = new LinkedList<>();
        mUserMap = new HashMap<>();
    }

    public static synchronized UserDatabase get(Context context) {
        if(sUserDatabase == null) {
            sUserDatabase = new UserDatabase(context);
        }
        return sUserDatabase;
    }

    public List<User> getUsers() {
        mUsers.clear();
        mUsernames.clear();
        mUserMap.clear();
        UserCursorWrapper wrapper = queryUser(null, null);

        try {
            wrapper.moveToFirst();
            while(wrapper.isAfterLast() == false) {
                User user = wrapper.getUser();
                mUsers.add(user);
                mUsernames.add(user.getUsername());
                mUserMap.put(user.getUsername(), user.getPassword());
                wrapper.moveToNext();
            }
        }
        finally {
            wrapper.close();
        }

        return mUsers;
    }

    public List<String> getUsernames () {
        return mUsernames;
    }

    private UserCursorWrapper queryUser(String where, String[] args) {
        Cursor cursor = mDatabase.query(
                Schema.UserTable.NAME, // table name
                null,                          // which columns; null for all
                where,                         // where clause, e.g. id=?
                args,                          // where arguments
                null,                          // group by
                null,                          // having
                null                           // order by
        );

        return new UserCursorWrapper(cursor);
    }

    public void addUser(User user) {
        ContentValues values = getContentvalues(user);
        mDatabase.insert(Schema.UserTable.NAME, null, values);
    }

    public void updateUser(User user) {
        String id = user.getID().toString();
        ContentValues values = getContentvalues(user);
        mDatabase.update(Schema.UserTable.NAME,
                values,
                Schema.UserTable.Cols.ID + "=?",
                new String[]{id});
    }

    public Map<String, String> getUserMap() {
        return mUserMap;
    }

    private static ContentValues getContentvalues(User user) {
        ContentValues values = new ContentValues();

        values.put(Schema.UserTable.Cols.ID, user.getID().toString());
        values.put(Schema.UserTable.Cols.USERNAME, user.getUsername());
        values.put(Schema.UserTable.Cols.PASSWORD, user.getPassword());

        return values;
    }

}
