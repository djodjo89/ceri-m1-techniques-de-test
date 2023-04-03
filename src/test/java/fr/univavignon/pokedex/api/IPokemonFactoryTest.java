package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
  @Test public void testCreatePokemon() {
    IPokemonFactory mockedFactory = Mockito.mock(IPokemonFactory.class);
    Pokemon charizard = new Pokemon(6, "charizard", 84, 78, 100, 3000, 78, 8000, 8, 100.0);
    Mockito.when(mockedFactory.createPokemon(6, 3000, 78, 8000, 8)).thenReturn(charizard);

    Pokemon actual = mockedFactory.createPokemon(6, 3000, 78, 8000, 8);

    assertEquals(charizard, actual);
    Mockito.verify(mockedFactory).createPokemon(6, 3000, 78, 8000, 8);

    assertEquals(6, actual.getIndex());
    assertEquals("charizard", actual.getName());
    assertEquals(84, actual.getAttack());
    assertEquals(78, actual.getDefense());
    assertEquals(100, actual.getStamina());
    assertEquals(3000, actual.getCp());
    assertEquals(78, actual.getHp());
    assertEquals(8000, actual.getDust());
    assertEquals(8, actual.getCandy());
    assertEquals(100.0, actual.getIv());
  }
}

