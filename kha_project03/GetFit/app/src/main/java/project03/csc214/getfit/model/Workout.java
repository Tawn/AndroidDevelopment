package project03.csc214.getfit.model;

/**
 * Created by Tkha on 6/29/17.
 */

public class Workout {
    private String mWorkout;
    private int mSet, mRep, mWeight;

    public Workout() {
        mWorkout = "Add workout";
        mSet = 0;
        mRep = 0;
        mWeight = 0;
    }

    public int getSet() {
        return mSet;
    }

    public void setSet(int set) {
        this.mSet = set;
    }

    public int getRep() {
        return mRep;
    }

    public void setRep(int rep) {
        this.mRep = rep;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        this.mWeight = weight;
    }

    public void setWorkout(String workout) {
        mWorkout = workout;
    }

    public String getWorkout() {
        return mWorkout;
    }
}
