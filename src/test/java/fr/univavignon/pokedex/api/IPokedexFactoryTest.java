package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
  @Test public void testCreatePokedex() {
    IPokemonFactory mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
    IPokedexFactory mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokedex mockedPokedex = Mockito.mock(IPokedex.class);
    IPokemonMetadataProvider mockedProvider = Mockito.mock(IPokemonMetadataProvider.class);
    
    Mockito.when(mockedPokedexFactory.createPokedex(mockedProvider, mockedPokemonFactory)).thenReturn(mockedPokedex);

    IPokedex actual = mockedPokedexFactory.createPokedex(mockedProvider, mockedPokemonFactory);

    assertEquals(actual, mockedPokedex);
    Mockito.verify(mockedPokedexFactory).createPokedex(mockedProvider, mockedPokemonFactory);
  }
}

