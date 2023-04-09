package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
	private IPokemonMetadataProvider provider;
	private IPokemonFactory factory;
	public PokemonTrainerFactory(IPokemonMetadataProvider provider, IPokemonFactory factory) {
		this.provider = provider;
		this.factory = factory;
	}

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		return new PokemonTrainer(name, team, pokedexFactory.createPokedex(provider, factory));
	}
}
