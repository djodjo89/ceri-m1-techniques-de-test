package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
  @Test public void testCreateTrainer() {
    IPokemonTrainerFactory mockedTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    IPokedexFactory mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokedex mockedPokedex = Mockito.mock(IPokedex.class);
    PokemonTrainer sacha = new PokemonTrainer("sacha", Team.VALOR, mockedPokedex);
    Mockito.when(mockedTrainerFactory.createTrainer("sacha", Team.VALOR, mockedPokedexFactory)).thenReturn(sacha);

    PokemonTrainer actual = mockedTrainerFactory.createTrainer("sacha", Team.VALOR, mockedPokedexFactory);

    assertEquals(actual, sacha);
    Mockito.verify(mockedTrainerFactory).createTrainer("sacha", Team.VALOR, mockedPokedexFactory);

    assertEquals("sacha", actual.getName());
    assertEquals(Team.VALOR, actual.getTeam());
    assertEquals(mockedPokedex, actual.getPokedex());
  }
}
