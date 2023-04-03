package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {
  static IPokedex mockedPokedex;
  static Pokemon charizard;
  @BeforeAll public static void initialize() {
    mockedPokedex = Mockito.mock(IPokedex.class);
    charizard = new Pokemon(6, "charizard", 84, 78, 100, 3000, 78, 8000, 8, 100.0);
  }
  @Test public void testSize() {
    Mockito.when(mockedPokedex.size()).thenReturn(0);

    int actual = mockedPokedex.size();

    assertEquals(0, actual);
    Mockito.verify(mockedPokedex).size();
  }
  @Test public void testAddPokemon() {
    Mockito.when(mockedPokedex.addPokemon(charizard)).thenReturn(1);

    int actual = mockedPokedex.addPokemon(charizard);

    assertEquals(1, actual);
    Mockito.verify(mockedPokedex).addPokemon(charizard);
  }
  @Test public void testGetPokemon() throws PokedexException {
    Mockito.when(mockedPokedex.getPokemon(1)).thenReturn(charizard);

    Pokemon actual = mockedPokedex.getPokemon(1);

    assertEquals(charizard, actual);
    Mockito.verify(mockedPokedex).size();
  }
  @Test public void testGetNonexistentPokemon() throws PokedexException {
    Mockito.when(mockedPokedex.getPokemon(0)).thenThrow(new PokedexException("ce pokemon n’existe pas"));

    assertThrows(PokedexException.class, () -> {
      mockedPokedex.getPokemon(0);
    });
    Mockito.verify(mockedPokedex).getPokemon(0);
  }
  @Test public void testGetPokemons() {
    Mockito.when(mockedPokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());

    List<Pokemon> actual = mockedPokedex.getPokemons();

    assertEquals(0, actual.size());
    Mockito.verify(mockedPokedex).getPokemons();
  }
}

