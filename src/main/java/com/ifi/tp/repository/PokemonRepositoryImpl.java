package com.ifi.tp.repository;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ifi.tp.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepositoryImpl implements PokemonRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<PokemonType> pokemons;

    public PokemonRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("/pokemons.json").getInputStream();
            this.pokemons = objectMapper.readValue(pokemonsStream, new TypeReference<List<PokemonType>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonById(int id) {
        return pokemons.parallelStream()
                .filter((pokemon -> pokemon.getId() == id))
                .findFirst().orElse(null);
    }

    @Override
    public PokemonType findPokemonByName(String name) {
        return pokemons.parallelStream()
                .filter((pokemon -> name.equals(pokemon.getName())))
                .findFirst().orElse(null);
    }

    @Override
    public List<PokemonType> findAllPokemon() {
        return this.pokemons;
    }

}
