package com.ifi.tp.controller;

import com.ifi.tp.bo.PokemonType;
import com.ifi.tp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonFromId(@PathVariable int id){
        return pokemonService.getPokemon(id);
    }

    @GetMapping("")
    List<PokemonType> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }
}
