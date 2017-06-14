package assignment06.csc214.listhandling.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Collection {

    private static Collection sCollection;
    private Map<UUID, Pokemon> collection;

    public Collection(Context context) {
        collection = new HashMap<>();

        // List of Pokémon
        addPokemon("Squirtle", "Water", 20);        // 1
        addPokemon("charmander", "Fire", 20);
        addPokemon("Pikachu", "Electric", 25);
        addPokemon("Bulbasaur", "Grass", 20);
        addPokemon("Diglet", "Ground", 15);         // 5
        addPokemon("Jigglypuff", "Normal", 30);
        addPokemon("Abra", "Psycic", 20);
        addPokemon("Articuno", "Ice", 170);
        addPokemon("Magmar", "Fire", 50);
        addPokemon("Electrode", "Electric", 40);    // 10
        addPokemon("Weedle", "Grass", 10);
        addPokemon("Pidgey", "Normal", 15);
        addPokemon("Ponyta", "Fire", 30);
        addPokemon("Ditto", "Normal", 20);
        addPokemon("Magnemite", "Electric", 25);    // 15
        addPokemon("Mew", "Psycic", 150);
        addPokemon("Starmie", "Water", 20);
        addPokemon("Onix", "Ground", 80);
        addPokemon("Magikarp", "Water", 10);
        addPokemon("Golem", "Ground", 120);         // 20

    }


    public void addPokemon(String name, String type, int HP) {
        Pokemon newPokemon = new Pokemon(name, type, HP);
        collection.put(newPokemon.getID(), newPokemon);

    }

    public static Collection get(Context context) {
        if(sCollection == null) {
            sCollection = new Collection(context);
        }
        return sCollection;
    }

    public List<Pokemon> getCollection() {
        List<Pokemon> list = new ArrayList<>(5);
        list.addAll(collection.values());
        return list;
    }





}
