package assignment06.csc214.listhandling.model;

import java.util.UUID;

public class Pokemon {

    private String mName, mType;
    private int mHitPoints;
    private UUID mID;

    public Pokemon (String mName, String mType, int mHitPoints) {
        this.mName = mName;
        this.mType = mType;
        this.mHitPoints = mHitPoints;
        mID = UUID.randomUUID();
    }

    public String getName() { return mName; }
    public String getmType() { return mType; }
    public int getmHitPoints() { return mHitPoints; }
    public UUID getID() { return mID; }

    @Override
    public String toString() { return getName() + "\nType: " + getmType() + "\nHP: " + getmHitPoints(); }
}
