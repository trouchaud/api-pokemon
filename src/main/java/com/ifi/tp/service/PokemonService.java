package com.ifi.tp.service;

import com.ifi.tp.bo.PokemonType;

import java.util.List;

public interface PokemonService {
    PokemonType getPokemon(int id);
    List<PokemonType> getAllPokemons();
}
