package fr.univavignon.pokedex.api;

/**
 * Factory class for a simple creation of Pokedex
 *
 */ 
public class PokedexFactory implements IPokedexFactory {
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		return new Pokedex(metadataProvider, pokemonFactory);
	}
}
