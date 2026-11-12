package com.krakdev.peliculas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

    @Autowired
    private PeliculaRepository repository;

    public Pelicula guardar(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    public List<Pelicula> listar() {
        return repository.findAll();
    }

    public Pelicula buscarPorId(Long id) {

        Optional<Pelicula> pelicula = repository.findById(id);

        if (pelicula.isPresent()) {
            return pelicula.get();
        }

        return null;
    }

    public Pelicula actualizar(Long id, Pelicula pelicula) {

        Optional<Pelicula> existente = repository.findById(id);

        if (existente.isPresent()) {

            pelicula.setId(id);

            return repository.save(pelicula);
        }

        return null;
    }

    public boolean eliminar(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return true;
        }

        return false;
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return repository.findByGenero(genero);
    }

    public List<Pelicula> buscarPorDisponible(boolean disponible) {
        return repository.findByDisponible(disponible);
    }
}
