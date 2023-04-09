package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Pokedex implements IPokedex {
	private HashSet<Pokemon> pokemons;
	private IPokemonMetadataProvider provider;
	private IPokemonFactory factory;

	public Pokedex(IPokemonMetadataProvider provider, IPokemonFactory factory) {
		pokemons = new HashSet<Pokemon>();
		this.provider = provider;
		this.factory = factory;
	}

	public int addPokemon(Pokemon pokemon) {
		pokemons.add(pokemon);
		return pokemon.getIndex();
	}

	public Pokemon getPokemon(int id) throws PokedexException {
		PokemonMetadata metadata = getPokemonMetadata(id);
		Pokemon pokemon = pokemons.stream()
			.filter(p -> p.getIndex() == metadata.getIndex())
			.findAny()
			.orElse(null);
		if (pokemon != null) return pokemon;
		throw new PokedexException("No Pokemon corresponds to the given index");
	}

	public List<Pokemon> getPokemons() {
		return new ArrayList<Pokemon>(pokemons);
	}

	@Override
	public int size() {
		return pokemons.size();
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		return getPokemons().stream().sorted(order).toList();
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return provider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
		return factory.createPokemon(index, cp, hp, dust, candy);
	}
}
