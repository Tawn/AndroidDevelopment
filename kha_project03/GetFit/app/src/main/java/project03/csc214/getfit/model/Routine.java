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
        mRoutine = null;
        mWorkout = null;
    }

    public void setWorkout(String workout) {
        mWorkout = workout;
    }

    public String getWorkouts() {
        return mWorkout;
    }

    public void setRoutin(String routine) {
        mRoutine = routine;
    }

    public String getRoutine() {
        return mRoutine;
    }

}
