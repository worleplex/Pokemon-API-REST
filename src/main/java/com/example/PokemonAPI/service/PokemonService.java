package com.example.PokemonAPI.service;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> obtenerTodos() {
        return pokemonRepository.findAll();
    }

    public Pokemon obtenerPorId(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public Pokemon crear(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon actualizarCompleto(Long id, Pokemon pokemon) {
        Pokemon otroPokemon = pokemonRepository.findById(id).orElse(null);
        if (otroPokemon == null) return null;
        otroPokemon.setNombre(pokemon.getNombre());
        otroPokemon.setTipo(pokemon.getTipo());
        otroPokemon.setNivel(pokemon.getNivel());
        otroPokemon.setAtaque(pokemon.getAtaque());
        otroPokemon.setDefensa(pokemon.getDefensa());
        otroPokemon.setDescripcion(pokemon.getDescripcion());
        otroPokemon.setImagenUrl(pokemon.getImagenUrl());
        return pokemonRepository.save(otroPokemon);
    }

    public Pokemon actualizarParcial(Long id, Pokemon cambios) {
        Pokemon otroPokemon = pokemonRepository.findById(id).orElse(null);
        if (otroPokemon == null) return null;
        if (cambios.getNombre() != null) otroPokemon.setNombre(cambios.getNombre());
        if (cambios.getTipo() != null) otroPokemon.setTipo(cambios.getTipo());
        if (cambios.getNivel() != null) otroPokemon.setNivel(cambios.getNivel());
        if (cambios.getAtaque() != null) otroPokemon.setAtaque(cambios.getAtaque());
        if (cambios.getDefensa() != null) otroPokemon.setDefensa(cambios.getDefensa());
        if (cambios.getDescripcion() != null) otroPokemon.setDescripcion(cambios.getDescripcion());
        if (cambios.getImagenUrl() != null) otroPokemon.setImagenUrl(cambios.getImagenUrl());
        return pokemonRepository.save(otroPokemon);
    }

    public void eliminar(Long id) {
        pokemonRepository.deleteById(id);
    }
}
