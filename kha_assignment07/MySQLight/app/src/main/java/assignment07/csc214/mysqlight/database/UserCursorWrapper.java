package assignment07.csc214.mysqlight.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

import assignment07.csc214.instagram.database.UserDbSchema.UserTable;

/**
 * Created by Tkha on 6/17/17.
 */

public class UserCursorWrapper extends CursorWrapper{

    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
        UUID id = UUID.fromString(getString(getColumnIndex(UserTable.Cols.ID)));
    }
}
