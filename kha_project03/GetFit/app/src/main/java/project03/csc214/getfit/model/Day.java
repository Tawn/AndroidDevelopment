package project03.csc214.getfit.model;

/**
 * Created by Tkha on 6/27/17.
 */

public class Day {

    private int mDay;
    private String mRoutine;
    private double mWeight;
    private int mReps;

    public Day() {
        mDay = 1;
        mRoutine = "No Progress Made";
        mWeight = 0;
        mReps = 0;
    }

    public String toString() {
        switch(mDay) {
            case 1: return "Sunday:     " + "Workout Routine";
            case 2: return "Monday:     " + "Workout Routine";
            case 3: return "Tuesday:    " + "Workout Routine";
            case 4: return "Wednesday:  " + "Workout Routine";
            case 5: return "Thursday:   " + "Workout Routine";
            case 6: return "Friday:     " + "Workout Routine";
            case 7: return "Saturday:   " + "Workout Routine";
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
            default: return " ";
        }
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

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        this.mWeight = weight;
    }

    public int getReps() {
        return mReps;
    }

    public void setReps(int reps) {
        this.mReps = reps;
    }

}
