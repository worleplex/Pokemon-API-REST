package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listar() {
        return pokemonService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pokemon listar(@PathVariable Long id) {
        return pokemonService.obtenerPorId(id);
    }

    @PostMapping
    public Pokemon crear(@RequestBody Pokemon pokemon) {
        return pokemonService.crear(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon actualizar(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarCompleto(id, pokemon);
    }

    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarParcial(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pokemonService.eliminar(id);
    }
}
