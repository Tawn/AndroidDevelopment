package project02.csc214.myinstagram.database;

/**
 * Created by Tkha on 6/18/17.
 */

public class Schema {
    public static final String DATABSE_NAME = "user_database.db";
    public static final int VERSION = 1;

    public static class UserTable {
        public static final String NAME = "user";

        public static final class Cols {
            public static final String USERNAME = "username";
            public static final String FIRSTNAME = "first_name";
            public static final String LASTNAME = "last_name";
            public static final String PASSWORD = "password";
            public static final String ID = "user_id";
        }

    }

}
