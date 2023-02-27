package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
  @Test public void testCreatePokemon() {
    IPokemonFactory mockedFactory = Mockito.mock(IPokemonFactory.class);
    Pokemon charizard = new Pokemon(6, "charizard", 84, 78, 100, 3000, 78, 8000, 8, 100.0);
    Mockito.when(mockedFactory.createPokemon(6, 3000, 78, 8000, 8)).thenReturn(charizard);

    Pokemon expectedPokemon = mockedFactory.createPokemon(6, 3000, 78, 8000, 8);

    assertEquals(expectedPokemon, charizard);
    Mockito.verify(mockedFactory).createPokemon(6, 3000, 78, 8000, 8);

    assertEquals(6, expectedPokemon.getIndex());
    assertEquals("charizard", expectedPokemon.getName());
    assertEquals(84, expectedPokemon.getAttack());
    assertEquals(78, expectedPokemon.getDefense());
    assertEquals(100, expectedPokemon.getStamina());
    assertEquals(3000, expectedPokemon.getCp());
    assertEquals(78, expectedPokemon.getHp());
    assertEquals(8000, expectedPokemon.getDust());
    assertEquals(8, expectedPokemon.getCandy());
    assertEquals(100.0, expectedPokemon.getIv());
  }
}

