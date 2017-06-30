package project03.csc214.getfit.model;

/**
 * Created by Tkha on 6/27/17.
 */

public class Day {

    private int mDay;
    private String mRoutine;
    private String mNote;


    public Day() {
        mDay = 1;
        mRoutine = "No Scheduled Workout";
        mNote = "No Note Recorded";
    }

    public String toString() {
        switch(mDay) {
            case 1: return "Sunday:     " + mRoutine;
            case 2: return "Monday:     " + mRoutine;
            case 3: return "Tuesday:    " + mRoutine;
            case 4: return "Wednesday:  " + mRoutine;
            case 5: return "Thursday:   " + mRoutine;
            case 6: return "Friday:     " + mRoutine;
            case 7: return "Saturday:   " + mRoutine;
            default: return " ";
        }
    }

    public String getDay() {
        switch(mDay) {
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            default: return "None";
        }
    }

    public int getDayNumber() {
        return mDay;
    }

    public void setDay(int day) {
        this.mDay = day;
    }

    public String getRoutine() {
        return mRoutine;
    }

    public void setRoutine(String routine) {
        this.mRoutine = routine;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        this.mNote = note;
    }
}
