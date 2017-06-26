package assignment07.csc214.mysqlites.database;

/**
 * Created by Tkha on 6/24/17.
 */

public class Schema {

    public static final String DATABSE_NAME = "pokemon_database.db";
    public static final int VERSION = 1;

    public static class PokemonTable {
        public static final String NAME = "user";

        public static final class Cols {
            public static final String NAME = "name";
            public static final String ID = "pokemon_id";
        }

    }

}
