package assignment07.csc214.mysqlites.model;

import java.util.UUID;

public class Pokemon {

    private String mName;
    private UUID mID;

    public Pokemon() {
        mID = UUID.randomUUID();
    }

    public String getName() { return mName; }
    public void setName(String name) { mName = name; }
    public UUID getID() { return mID; }
    public void setID(UUID id) {
        mID = id;
    }

    @Override
    public String toString() { return getName(); }
}
