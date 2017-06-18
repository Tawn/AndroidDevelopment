package project02.csc214.myinstagram.model;

import java.util.UUID;

/**
 * Created by Tkha on 6/17/17.
 */

public class User {

    private String mUsername;
    private String mPassword;
    private String mFirstname;

    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String lastname) {
        this.mLastname = lastname;
    }

    private String mLastname;
    private UUID mID;

    public User() {
        mID = UUID.randomUUID();
    }

    public String getFirstname() { return mFirstname; }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID id) {
        mID = id;
    }

    public String toString() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword (String password) {
        mPassword = password;
    }

}
