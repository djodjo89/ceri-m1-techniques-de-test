package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PokemonFactoryInterfaceTest {
  @Test
  public void testCreatePokemon() throws PokedexException {
    final PokemonMetadataProviderInterface provider =
        new PokemonMetadataProvider(
            new HashSet<PokemonMetadata>(
                List.of(new PokemonMetadata(6, "charizard", 84, 78, 100))));
    final PokemonFactoryInterface factory = new PokemonFactory(provider);
    final Pokemon charizard = new Pokemon(6, "charizard", 84, 78, 100, 3000, 78, 8000, 8, 100.0);

    final Pokemon actual = factory.createPokemon(6, 3000, 78, 8000, 8);

    assertEquals(
        charizard.getIndex(), actual.getIndex(), "createPokemon should create a charizard");
    assertEquals(6, actual.getIndex());
    assertEquals("charizard", actual.getName());
    assertEquals(84, actual.getAttack());
    assertEquals(78, actual.getDefense());
    assertEquals(100, actual.getStamina());
    assertEquals(3000, actual.getCp());
    assertEquals(78, actual.getHp());
    assertEquals(8000, actual.getDust());
    assertEquals(8, actual.getCandy());
    assertTrue(actual.getIv() > 0.0 && actual.getIv() <= 100.0);
  }
}
