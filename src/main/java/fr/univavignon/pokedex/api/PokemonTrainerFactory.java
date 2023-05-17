package fr.univavignon.pokedex.api;

/**
 * Basic implementation of the PokemonTrainerFactoryInterface.
 *
 * @author lop
 */
public class PokemonTrainerFactory implements PokemonTrainerFactoryInterface {
  private PokemonMetadataProviderInterface provider;
  private PokemonFactoryInterface factory;

  /**
   * Default constructor.
   *
   * @param provider PokemonMetadataProviderInterface provider.
   * @param factory PokemonFactoryInterface factory.
   */
  public PokemonTrainerFactory(
      PokemonMetadataProviderInterface provider, PokemonFactoryInterface factory) {
    this.provider = provider;
    this.factory = factory;
  }

  @Override
  public PokemonTrainer createTrainer(
      String name, Team team, PokedexFactoryInterface pokedexFactory) {
    return new PokemonTrainer(name, team, pokedexFactory.createPokedex(provider, factory));
  }
}
