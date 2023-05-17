package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class PokedexFactoryInterfaceTest {
    @Test
    public void testCreatePokedex() {
        PokemonMetadataProviderInterface provider =
                new PokemonMetadataProvider(
                        new HashSet<PokemonMetadata>(
                                List.of(
                                        new PokemonMetadata(1, "bulbasaur", 49, 49, 45),
                                        new PokemonMetadata(6, "charizard", 84, 78, 100))));
        PokemonFactoryInterface pokemonFactory = new PokemonFactory(provider);
        PokedexFactoryInterface pokedexFactory = new PokedexFactory();

        PokedexInterface actual = pokedexFactory.createPokedex(provider, pokemonFactory);

        assertEquals(0, actual.size());
    }
}
