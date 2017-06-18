package assignment07.csc214.instagram.model;

import java.util.UUID;

/**
 * Created by Tkha on 6/17/17.
 */

public class User {

    private String mUsername;
    private UUID mID;

    public User (String username) {
        mUsername = username;
        mID = UUID.randomUUID();

    }

    public String getUsername() {
        return mUsername;
    }

    public UUID getID() {
        return mID;
    }

    public String toString() {
        return mUsername;
    }

}
