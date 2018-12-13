package com.ifi.tp.service;

import com.ifi.tp.repository.PokemonRepository;
import com.ifi.tp.repository.PokemonRepositoryImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PokemonServiceImplTest {

    @Test
    void pokemonRepository_shouldBeCalled_whenFindById(){
        var pokemonRepository = mock(PokemonRepository.class);
        var pokemonService = new PokemonServiceImpl(pokemonRepository);

        pokemonService.getPokemon(25);

        verify(pokemonRepository).findPokemonById(25);
    }

    @Test
    void pokemonRepository_shouldBeCalled_whenFindAll(){
        var pokemonRepository = mock(PokemonRepository.class);
        var pokemonService = new PokemonServiceImpl(pokemonRepository);

        pokemonService.getAllPokemons();

        verify(pokemonRepository).findAllPokemon();
    }

    @Test
    void applicationContext_shouldLoadPokemonService(){
        var context = new AnnotationConfigApplicationContext(PokemonServiceImpl.class, PokemonRepositoryImpl.class);
        var serviceByName = context.getBean("pokemonServiceImpl");
        var serviceByClass = context.getBean(PokemonService.class);

        assertEquals(serviceByName, serviceByClass);
        assertNotNull(serviceByName);
        assertNotNull(serviceByClass);
    }

    @Test
    void pokemonRepository_shouldBeAutowired_withSpring(){
        var context = new AnnotationConfigApplicationContext(PokemonServiceImpl.class, PokemonRepositoryImpl.class);
        var service = context.getBean(PokemonServiceImpl.class);
        assertNotNull(service.pokemonRepository);
    }

}