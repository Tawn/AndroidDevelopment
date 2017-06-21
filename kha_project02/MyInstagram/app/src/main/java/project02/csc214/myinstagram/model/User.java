package project02.csc214.myinstagram.model;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tkha on 6/17/17.
 */

public class User {

    private String mUsername;
    private String mPassword;
    private String mFirstname;
    private String mLastname;
    private String mPhotoPath;
    private UUID mID;

    public User() {
        mID = UUID.randomUUID();
        mPhotoPath = "abc";
    }


    public String toString() {
        return "@ " + mUsername + "\n"
                + mFirstname + " " + mLastname;
    }

    public String getPhotoPath() {
        return mPhotoPath;
    }

    public void setPhotoPath(String path) { mPhotoPath = path; }


    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String lastname) {
        mLastname = lastname;
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

    public String getPassword() {
        return mPassword;
    }

    public void setPassword (String password) {
        mPassword = password;
    }

}
