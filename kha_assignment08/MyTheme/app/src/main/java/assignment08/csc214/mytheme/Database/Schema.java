package assignment08.csc214.mytheme.Database;

/**
 * Created by Tkha on 6/21/17.
 */

public class Schema {

    public static final String DATABASE_NAME = "person_database.db";
    public static final int VERSION  = 1;

    public static class PersonTable {
        public static final String NAME = "person";
        public static final class Columns {
            public static final String NAME = "name";
        }

    }

}
