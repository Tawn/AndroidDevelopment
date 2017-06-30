package project03.csc214.getfit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tkha on 6/27/17.
 */

public class Routine {

    private String mRoutine;
    private String mWorkout;

    public Routine() {
        mRoutine = "Add routine";
        mWorkout = "Add workout";

    }
    public void setWorkout(String workout) {
        mWorkout = workout;
    }

    public String getWorkout() {
        return mWorkout;
    }

    public void setRoutine(String routine) {
        mRoutine = routine;
    }

    public String getRoutine() {
        return mRoutine;
    }

}
