package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PokemonMetadataProviderInterfaceTest {
  static PokemonMetadataProvider provider;

  @BeforeAll
  public static void initialize() {
    provider =
        new PokemonMetadataProvider(
            new HashSet<PokemonMetadata>(List.of(new PokemonMetadata(1, "bulbasaur", 49, 49, 45))));
  }

  @Test
  public void testGetPokemonMetadata() throws PokedexException {
    PokemonMetadata actual = provider.getPokemonMetadata(1);
    assertEquals("bulbasaur", actual.getName());
  }

  @Test
  public void testGetNonexistentPokemonMetadata() throws PokedexException {
    assertThrows(
        PokedexException.class,
        () -> {
          provider.getPokemonMetadata(722);
        });
  }
}
