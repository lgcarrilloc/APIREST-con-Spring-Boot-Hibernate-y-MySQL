package com.krakdev.peliculas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private ServicioPelicula servicio;

    @PostMapping
    public ResponseEntity<Pelicula> guardar(@RequestBody Pelicula pelicula) {

        Pelicula nueva = servicio.guardar(pelicula);

        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() {

        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Pelicula pelicula = servicio.buscarPorId(id);

        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody Pelicula pelicula) {

        Pelicula actualizada = servicio.actualizar(id, pelicula);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        boolean eliminado = servicio.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Pelicula eliminada correctamente");
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Pelicula>> buscarGenero(
            @PathVariable String genero) {

        return ResponseEntity.ok(
                servicio.buscarPorGenero(genero));
    }

    @GetMapping("/disponible/{disponible}")
    public ResponseEntity<List<Pelicula>> buscarDisponible(
            @PathVariable boolean disponible) {

        return ResponseEntity.ok(
                servicio.buscarPorDisponible(disponible));
    }
}