package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class IPokemonTrainerFactoryTest {
  @Test public void testCreateTrainer() {
    IPokemonMetadataProvider provider = new PokemonMetadataProvider(
        new HashSet<PokemonMetadata>());
    IPokemonFactory pokemonFactory = new PokemonFactory(provider);
    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory(provider, pokemonFactory);
    PokemonTrainer sacha = new PokemonTrainer("sacha", Team.VALOR, pokedexFactory.createPokedex(provider, pokemonFactory));

    PokemonTrainer actual = trainerFactory.createTrainer("sacha", Team.VALOR, pokedexFactory);

    assertEquals("sacha", actual.getName());
    assertEquals(Team.VALOR, actual.getTeam());
    assertEquals(sacha.getPokedex().size(), actual.getPokedex().size());
  }
}
