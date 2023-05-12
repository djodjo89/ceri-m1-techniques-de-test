package fr.univavignon.pokedex.api;

/** Factory class for a simple creation of Pokedex. */
public class PokedexFactory implements PokedexFactoryInterface {
  public PokedexInterface createPokedex(
      PokemonMetadataProviderInterface metadataProvider, PokemonFactoryInterface pokemonFactory) {
    return new Pokedex(metadataProvider, pokemonFactory);
  }
}
