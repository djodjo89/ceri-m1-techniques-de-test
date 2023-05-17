package fr.univavignon.pokedex.api;

import java.util.HashSet;

/**
 * Basic implementation of the PokemonMetadataProviderInterface.
 *
 * @author lop
 */
public class PokemonMetadataProvider implements PokemonMetadataProviderInterface {
  private HashSet<PokemonMetadata> metadatas;
  private static int NB_MAX_POKEMON_METADATA = 151;

  /**
   * Creates a new pokemon metadata provider using the given
   * <code>metadatas</code>.
   *
   * @param metadatas metadatas to provide.
   */
  public PokemonMetadataProvider(HashSet<PokemonMetadata> metadatas) {
    this.metadatas = metadatas;
  }

  private boolean isIndexValid(int index) {
    return index >= 0 && index < NB_MAX_POKEMON_METADATA;
  }

  private void throwExceptionIfIsIndexInvalid(int index) throws PokedexException {
    if (!isIndexValid(index)) {
      throw new PokedexException("The index given is invalid");
    }
  }

  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    throwExceptionIfIsIndexInvalid(index);
    PokemonMetadata metadata = metadatas.stream().filter(m -> m.getIndex() == index).findAny().orElse(null);
    if (metadata != null) {
      return metadata;
    }
    throw new PokedexException("No Metadata corresponds to the index given");
  }
}
