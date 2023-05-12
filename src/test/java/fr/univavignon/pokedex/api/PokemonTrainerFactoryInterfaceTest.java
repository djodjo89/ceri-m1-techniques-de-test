package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class PokemonTrainerFactoryInterfaceTest {
  @Test
  public void testCreateTrainer() {
    PokemonMetadataProviderInterface provider =
        new PokemonMetadataProvider(new HashSet<PokemonMetadata>());
    PokemonFactoryInterface pokemonFactory = new PokemonFactory(provider);
    PokedexFactoryInterface pokedexFactory = new PokedexFactory();
    PokemonTrainerFactoryInterface trainerFactory =
        new PokemonTrainerFactory(provider, pokemonFactory);
    PokemonTrainer sacha =
        new PokemonTrainer(
            "sacha", Team.VALOR, pokedexFactory.createPokedex(provider, pokemonFactory));

    PokemonTrainer actual = trainerFactory.createTrainer("sacha", Team.VALOR, pokedexFactory);

    assertEquals("sacha", actual.getName());
    assertEquals(Team.VALOR, actual.getTeam());
    assertEquals(sacha.getPokedex().size(), actual.getPokedex().size());
  }
}
