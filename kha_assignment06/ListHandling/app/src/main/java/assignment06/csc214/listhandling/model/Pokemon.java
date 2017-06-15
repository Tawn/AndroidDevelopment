package assignment06.csc214.listhandling.model;

import java.util.UUID;

public class Pokemon {

    private String mName, mType, mDescription;
    private int mHitPoints;
    private UUID mID;

    public Pokemon (String name, String type, int hitPoints, String description) {
        mName = name;
        mType = type;
        mHitPoints = hitPoints;
        mDescription = description;
        mID = UUID.randomUUID();
    }

    public String getName() { return mName; }
    public String getmType() { return mType; }
    public int getmHitPoints() { return mHitPoints; }
    public String getDescription() { return mDescription; };
    public UUID getID() { return mID; }

    @Override
    public String toString() { return getName() + "\nType: " + getmType() + "\nHP: " + getmHitPoints(); }
}
