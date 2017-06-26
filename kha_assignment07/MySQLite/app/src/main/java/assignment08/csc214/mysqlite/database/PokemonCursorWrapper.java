package assignment08.csc214.mysqlite.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import java.util.UUID;

import assignment08.csc214.mysqlite.model.Pokemon;

/**
 * Created by Tkha on 6/24/17.
 */

public class PokemonCursorWrapper extends CursorWrapper {

    public static final String TAG = "UserCursorWrapper";
    public PokemonCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Pokemon getPokemon() {
        Log.i(TAG, "getPokemon: Getting Pokemon");
        UUID id = UUID.fromString(getString(getColumnIndex(Schema.PokemonTable.Cols.ID)));
        String name = getString(getColumnIndex(Schema.PokemonTable.Cols.NAME));


        Pokemon pokemon = new Pokemon();
        pokemon.setID(id);
        pokemon.setName(name);
        return pokemon;
    }
}
