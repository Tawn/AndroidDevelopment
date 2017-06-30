package project03.csc214.getfit.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import java.util.UUID;

import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.Routine;
import project03.csc214.getfit.model.Workout;

/**
 * Created by Tkha on 6/27/17.
 */

public class DatabaseCursorWrapper extends CursorWrapper {

    public DatabaseCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Day getDays() {
        int day_of_week = getInt(getColumnIndex(Schema.ProgressTable.Cols.DAY));
        String routine = getString(getColumnIndex(Schema.ProgressTable.Cols.ROUTINE));
        String note = getString(getColumnIndex(Schema.ProgressTable.Cols.NOTE));

        Day day = new Day();
        day.setDay(day_of_week);
        day.setRoutine(routine);
        day.setNote(note);
        return day;
    }

}
