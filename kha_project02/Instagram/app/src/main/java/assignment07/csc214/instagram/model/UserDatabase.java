package assignment07.csc214.instagram.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Tkha on 6/17/17.
 */

public class UserDatabase {

    private static UserDatabase sUsers;
    private Map<UUID, User> mUserDatabase;

    public UserDatabase (Context context) {
        mUserDatabase = new HashMap<>();

        addUser("thanh");
        addUser("bobby");
        addUser("jeff");
    }

    public void addUser(String username) {
        User user = new User(username);
        mUserDatabase.put(user.getID(), user);

    }

    public static UserDatabase get(Context context) {
        if(sUsers == null) {
            sUsers = new UserDatabase(context);
        }
        return sUsers;
    }

    public List<User> getCollection() {
        List<User> list = new ArrayList<>();
        list.addAll(mUserDatabase.values());
        return list;
    }
}
