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

        // List of Pokémon in collection
        addPokemon("Squirtle", "Water", 20, "A turtle-looking creature. " +
                "One of the three starting Pokémon in the Kanto region");    // 1

        addPokemon("Charmander", "Fire", 20, "A firey lizard. " +
                "One of the three starting Pokémon in the Kanto region");

        addPokemon("Pikachu", "Electric", 25, "A yellow lightning rat. " +
                "Ash's main Pokémon that doesn't like to go in Pokéballs");

        addPokemon("Bulbasaur", "Grass", 20, "a fat frog with pedals grown on back. " +
                "One of the three starting Pokémon in the Kanto region");

        addPokemon("Diglet", "Ground", 15, "A creature that just digs. " +
                "Rarely shown in any episodes.");                    // 5

        addPokemon("Jigglypuff", "Normal", 30, "A pink-singing creature " +
                "Pranks people by putting them to sleep, then draws on face");

        addPokemon("Abra", "Psycic", 20, "A whos evolution bends spoons " +
                "Two spoons if in it's final evolution");

        addPokemon("Articuno", "Ice", 170, "a flying ice-bird. " +
                "Hard to catch with just a pokéball.");

        addPokemon("Magmar", "Fire", 50, "a depressing lava creature. " +
                "Weakness to water-type Pokémon, obviously.");

        addPokemon("Electrode", "Electric", 40, "A suicide ball. " +
                "Don't be fooled thinking that it's a pokéball");    // 10

        addPokemon("Weedle", "Grass", 10, "A ground mosquito. " +
                "Cacoons to a bee.");

        addPokemon("Pidgey", "Normal", 15, "A typical bird. " +
                "Evolves into a bigger typical bird.");

        addPokemon("Ponyta", "Fire", 30, "a horse with firey-hairs. " +
                "Evoled into a bigger horse with fiery-hairs.");

        addPokemon("Ditto", "Normal", 20, "A transforming create. " +
                "Can transform into any Pokémon.");

        addPokemon("Magnemite", "Electric", 25, "An eye with two magnets " +
                "Large metal with magnets that defies gravity.");    // 15

        addPokemon("Mew", "Psycic", 150, "A legendary Pokémon." +
                "Only one available");

        addPokemon("Psyduck", "Water", 20, "A confused duck. " +
                "Evolved into a not-confused duck");
        addPokemon("Onix", "Ground", 80, "A large living pile of boulders." +
                "Somehow gets hurt by water");
        addPokemon("Magikarp", "Water", 10, "A flappy fish. " +
                "It's evolution unexpected");

        addPokemon("Golem", "Ground", 120, "A living big rock. " +
                "Final evolution of geodude");                       // 20

    }


    public void addPokemon(String name, String type, int HP, String desc) {
        Pokemon newPokemon = new Pokemon(name, type, HP, desc);
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
