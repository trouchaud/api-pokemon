package com.ifi.tp.repository;

import com.ifi.tp.bo.PokemonType;

import java.util.List;

public interface PokemonRepository {
    PokemonType findPokemonById(int id);
    PokemonType findPokemonByName(String name);
    List<PokemonType> findAllPokemon();
}
