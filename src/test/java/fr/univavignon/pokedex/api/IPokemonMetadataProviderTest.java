package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
  static IPokemonMetadataProvider mockedProvider;
  @BeforeAll public static void initialize() {
    mockedProvider = Mockito.mock(IPokemonMetadataProvider.class);
  }
  @Test public void testGetPokemonMetadata() throws PokedexException {
    PokemonMetadata bulbasaurMetadata = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);
    Mockito.when(mockedProvider.getPokemonMetadata(1)).thenReturn(bulbasaurMetadata);

    PokemonMetadata actual = mockedProvider.getPokemonMetadata(1);

    assertEquals(actual, bulbasaurMetadata);
    Mockito.verify(mockedProvider).getPokemonMetadata(1);
  }
  @Test public void testGetNonexistentPokemonMetadata() throws PokedexException {
    Mockito.when(mockedProvider.getPokemonMetadata(722)).thenThrow(new PokedexException("ce pokemon n’existe pas encore"));

    assertThrows(PokedexException.class, () -> {
      mockedProvider.getPokemonMetadata(722);
    });
    Mockito.verify(mockedProvider).getPokemonMetadata(722);
  }
}
