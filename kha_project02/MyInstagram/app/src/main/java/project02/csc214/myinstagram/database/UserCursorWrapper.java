package project02.csc214.myinstagram.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import java.util.UUID;

import project02.csc214.myinstagram.model.User;

/**
 * Created by Tkha on 6/18/17.
 */

public class UserCursorWrapper extends CursorWrapper {

    public static final String TAG = "UserCursorWrapper";
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser() {
        Log.i(TAG, "getUser: Getting Users");
        UUID id = UUID.fromString(getString(getColumnIndex(Schema.UserTable.Cols.ID)));
        String username = getString(getColumnIndex(Schema.UserTable.Cols.USERNAME));
        String first = getString(getColumnIndex(Schema.UserTable.Cols.FIRSTNAME));
        String last = getString(getColumnIndex(Schema.UserTable.Cols.LASTNAME));
        String password = getString(getColumnIndex(Schema.UserTable.Cols.PASSWORD));

        User user = new User();
        user.setID(id);
        user.setUsername(username);
        user.setFirstname(first);
        user.setLastname(last);
        user.setPassword(password);
        return user;
    }
}
