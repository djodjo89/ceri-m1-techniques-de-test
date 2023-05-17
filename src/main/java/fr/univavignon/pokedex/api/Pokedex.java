package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Basic implementation of the PokedexInterface.
 *
 * @author lop
 */
public class Pokedex implements PokedexInterface {
    private HashSet<Pokemon> pokemons;
    private PokemonMetadataProviderInterface provider;
    private PokemonFactoryInterface factory;

    /**
     * Default constructor.
     *
     * @param provider PokemonMetadataProviderInterface provider.
     * @param factory PokemonFactoryInterface factory.
     */
    public Pokedex(PokemonMetadataProviderInterface provider, PokemonFactoryInterface factory) {
        pokemons = new HashSet<Pokemon>();
        this.provider = provider;
        this.factory = factory;
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return provider.getPokemonMetadata(index);
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
            throws PokedexException {
        return factory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Add the pokemon denoted by the given <code>index</code> to the Pokedex.
     *
     * @param pokemon Pokemon to add.
     * @return index Index of the added pokemon.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    /**
     * Retrieves the pokemon denoted by the given <code>id</code>.
     *
     * @param id Index of the pokemon to retrieve.
     * @return the Pokemon.
     * @throws PokedexException If the given <code>id</code> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        PokemonMetadata metadata = getPokemonMetadata(id);
        Pokemon pokemon =
                pokemons.stream()
                        .filter(p -> p.getIndex() == metadata.getIndex())
                        .findAny()
                        .orElse(null);
        if (pokemon != null) {
            return pokemon;
        }
        throw new PokedexException("No Pokemon corresponds to the given index");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<Pokemon>(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return getPokemons().stream().sorted(order).toList();
    }
}
