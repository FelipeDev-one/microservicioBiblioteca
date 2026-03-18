package com.example.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service //anotación obligatoria para todos los servicios, se comunica con el controlador y el repositorio

public class LibroService {

    @Autowired //anotación que se comunica con el repositorio para usar sus funciones
    private LibroRepository LibroRepository;

    //función para traer todos los libros del repositorio
    public List<Libro> getLibros (){
        return LibroRepository.obtenerLibros();
    }
    //función para traer libro mediante su id
    public Libro getLibroById(int id){
        return LibroRepository.buscarPorId(id);
    }
    //función para guardar libro
    public Libro saveLibro(Libro lib){
        return LibroRepository.guardarLibro(lib);
    }
    //función para modificar libro
    public Libro updateLibro(Libro lib){
        return LibroRepository.actualizarLibro(lib);
    }
    //función para eliminar un libro
    public String deleteLibro(int id){
        LibroRepository.eliminarLibro(id);
        return "Libro Eliminado";
    }
}

/*

    } */