package assignment07.csc214.mysqlites.poke_center;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import assignment07.csc214.mysqlites.R;
import assignment07.csc214.mysqlites.database.PokemonDatabase;
import assignment07.csc214.mysqlites.model.Pokemon;

public class AddPokemonActivity extends AppCompatActivity {

    public static final String TAG = "AddPokemonActivity";
    private EditText etAddPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: invoked");
        setContentView(R.layout.activity_add_pokemon);
        etAddPokemon = (EditText)findViewById(R.id.et_add_pokemon);

    }

    public void addPokemonButtonPress(View view) {
        Pokemon pokemon = new Pokemon();
        String name = etAddPokemon.getText().toString();
        pokemon.setName(name);

        PokemonDatabase database = PokemonDatabase.get(getApplicationContext());
        database.addUser(pokemon);
        Log.i(TAG, "addPokemonButtonPress: # of Pokemons: " + database.getUsers().size());
        finish();

    }
}
