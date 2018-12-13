package com.ifi.tp.controller;

import com.ifi.tp.bo.PokemonType;
import com.ifi.tp.service.PokemonService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonControllerTest {

    @Test
    void getPokemon_shouldCallTheService(){
        var service = mock(PokemonService.class);
        var controlleur = new PokemonController(service);

        var pikachu = new PokemonType();
        pikachu.setId(25);
        pikachu.setName("pikachu");
        when(service.getPokemon(25)).thenReturn(pikachu);

        var pokemon = controlleur.getPokemonFromId(25);
        assertEquals("pikachu", pokemon.getName());

        verify(service).getPokemon(25);
    }

    @Test
    void getAllPokemons_shouldCallTheService(){
        var service = mock(PokemonService.class);
        var controlleur = new PokemonController(service);

        controlleur.getAllPokemons();

        verify(service).getAllPokemons();
    }

}