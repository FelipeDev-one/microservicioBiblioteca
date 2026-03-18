package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController //anotación obligatoria para todos los controladores, se comunica con el servicio
@RequestMapping("/api/libros") //anotación para definir la ruta de acceso a los servicios del controlador
public class LibroController { 
    @Autowired 
    private LibroService libroService;

    //obtener datos de todos los libros
    @GetMapping()
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }
    
    //agregar datos de un libro
    @PostMapping()
    public Libro agregarLibro(@RequestBody Libro lib) { //busca la información en el body
        return libroService.saveLibro(lib);
    }

    //Buscar un libro por su id
    @GetMapping("{id}")
    public Libro buscarPorId(@PathVariable int id) { //busca la información en la url
        return libroService.getLibroById(id);
    }
    
    //actualizar un libro
    @PutMapping("modificar/{id}")
    public Libro modificarLibro(@PathVariable int id, @RequestBody Libro lib) {
        return libroService.updateLibro(lib);
    }

    //eliminar un libro
    @DeleteMapping("{id}")
    public String eliminarLibroPorId(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

}
