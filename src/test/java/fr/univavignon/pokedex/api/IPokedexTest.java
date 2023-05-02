package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.HashSet;
import java.util.List;

public class IPokedexTest {
  static IPokedex pokedex;
  static Pokemon charizard;
  @BeforeAll public static void initialize() throws PokedexException {
    IPokemonMetadataProvider provider = new PokemonMetadataProvider(
        new HashSet<PokemonMetadata>(List.of(
            new PokemonMetadata(1, "bulbasaur", 49, 49, 45)
        )));
    IPokemonFactory factory = new PokemonFactory(provider);
    pokedex = new Pokedex(provider, factory);
    charizard = factory.createPokemon(1, 3000, 78, 8000, 8);
  }
  @Test public void testSize() {
    int actual = pokedex.size();

    assertEquals(0, actual);
  }
  @Test public void testAddPokemon() {
    int actual = pokedex.addPokemon(charizard);

    assertEquals(1, actual);
  }
  @Test public void testGetPokemon() throws PokedexException {
    pokedex.addPokemon(charizard);
    Pokemon actual = pokedex.getPokemon(1);

    assertEquals(charizard, actual);
  }
  @Test public void testGetNonexistentPokemon() throws PokedexException {
    assertThrows(PokedexException.class, () -> {
      pokedex.getPokemon(0);
    });
  }
  @Test public void testGetPokemons() {
    List<Pokemon> actual = pokedex.getPokemons();

    assertEquals(1, actual.size());
  }
}

