package project03.csc214.getfit.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import java.util.UUID;

import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.Routine;

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

        Day day = new Day();
        day.setDay(day_of_week);
        day.setRoutine(routine);
        return day;
    }

    public Routine getRoutine() {
        String day_routine = getString(getColumnIndex(Schema.DayTable.Cols.ROUTINE));
        String workout = getString(getColumnIndex(Schema.DayTable.Cols.WORKOUT));

        Routine routine = new Routine();
//        routines.setRoutine(day_routine);
//        routines.setWorkout(workout);
        return routine;
    }
}
