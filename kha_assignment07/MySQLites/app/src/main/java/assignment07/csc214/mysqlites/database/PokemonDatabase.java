package assignment07.csc214.mysqlites.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import assignment07.csc214.mysqlites.model.Pokemon;

/**
 * Created by Tkha on 6/24/17.
 */

public class PokemonDatabase {

    private static PokemonDatabase sPokemonDatabase;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;
    private final List<Pokemon> mUsers;

    private PokemonDatabase(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DatabaseHelper(mContext).getWritableDatabase();
        mUsers = new LinkedList<>();

    }

    public static synchronized PokemonDatabase get(Context context) {
        if(sPokemonDatabase == null) {
            sPokemonDatabase = new PokemonDatabase(context);
        }
        return sPokemonDatabase;
    }

    public List<Pokemon> getUsers() {
        mUsers.clear();
        PokemonCursorWrapper wrapper = queryUser(null, null);

        try {
            wrapper.moveToFirst();
            while(wrapper.isAfterLast() == false) {
                Pokemon pokemon = wrapper.getPokemon();
                mUsers.add(pokemon);
                wrapper.moveToNext();
            }
        }
        finally {
            wrapper.close();
        }

        return mUsers;
    }


    private PokemonCursorWrapper queryUser(String where, String[] args) {
        Cursor cursor = mDatabase.query(
                Schema.PokemonTable.NAME, // table name
                null,                          // which columns; null for all
                where,                         // where clause, e.g. id=?
                args,                          // where arguments
                null,                          // group by
                null,                          // having
                null                           // order by
        );

        return new PokemonCursorWrapper(cursor);
    }

    public void addUser(Pokemon pokemon) {
        ContentValues values = getContentvalues(pokemon);
        mDatabase.insert(Schema.PokemonTable.NAME, null, values);
    }

    public void updateUser(Pokemon pokemon) {
        String id = pokemon.getID().toString();
        ContentValues values = getContentvalues(pokemon);
        mDatabase.update(Schema.PokemonTable.NAME,
                values,
                Schema.PokemonTable.Cols.ID + "=?",
                new String[]{id});
    }

    private static ContentValues getContentvalues(Pokemon pokemon) {
        ContentValues values = new ContentValues();

        values.put(Schema.PokemonTable.Cols.ID, pokemon.getID().toString());
        values.put(Schema.PokemonTable.Cols.NAME, pokemon.getName());

        return values;
    }

}
