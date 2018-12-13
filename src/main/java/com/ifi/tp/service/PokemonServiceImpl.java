package com.ifi.tp.service;

import com.ifi.tp.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.tp.repository.PokemonRepository;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{

    final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<PokemonType> getAllPokemons(){
        return this.pokemonRepository.findAllPokemon();
    }

    @Override
    public PokemonType getPokemon(int id) {
        return this.pokemonRepository.findPokemonById(id);
    }
}
