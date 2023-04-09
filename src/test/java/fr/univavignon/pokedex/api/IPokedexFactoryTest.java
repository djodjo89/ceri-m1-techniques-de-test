package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IPokedexFactoryTest {
  @Test public void testCreatePokedex() {
     IPokemonMetadataProvider provider = new PokemonMetadataProvider(
        new HashSet<PokemonMetadata>(List.of(
            new PokemonMetadata(1, "bulbasaur", 49, 49, 45),
            new PokemonMetadata(6, "charizard", 84, 78, 100)
        )));
    IPokemonFactory pokemonFactory = new PokemonFactory(provider);
    IPokedexFactory pokedexFactory = new PokedexFactory();
    
    IPokedex actual = pokedexFactory.createPokedex(provider, pokemonFactory);

    assertEquals(0, actual.size());
  }
}

