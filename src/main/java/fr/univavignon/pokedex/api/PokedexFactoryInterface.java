package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create Pokedex instance.
 *
 * @author fv
 */
public interface PokedexFactoryInterface {

    /**
     * Creates a new pokedex instance using the given <code>metadataProvider</code> and <code>
     * pokemonFactory</code>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    PokedexInterface createPokedex(
            PokemonMetadataProviderInterface metadataProvider,
            PokemonFactoryInterface pokemonFactory);
}
