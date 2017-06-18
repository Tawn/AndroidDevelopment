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
        Log.i(TAG, "getUser: Getting user.");
        UUID id = UUID.fromString(getString(getColumnIndex(Schema.UserTable.Cols.ID)));
        String username = getString(getColumnIndex(Schema.UserTable.Cols.USERNAME));
        String password = getString(getColumnIndex(Schema.UserTable.Cols.PASSWORD));

        User user = new User();
        user.setID(id);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
