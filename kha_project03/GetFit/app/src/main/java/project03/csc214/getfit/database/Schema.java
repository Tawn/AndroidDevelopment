package project03.csc214.getfit.database;

/**
 * Created by Tkha on 6/18/17.
 */

public class Schema {
    public static final String DATABSE_NAME = "user_database.db";
    public static final int VERSION = 1;

    public static class ProgressTable {
        public static final String NAME = "progress";

        public static final class Cols {
            public static final String DAY = "day";
            public static final String ROUTINE = "routine";
            public static final String NOTE = "note";

        }

    }

}
