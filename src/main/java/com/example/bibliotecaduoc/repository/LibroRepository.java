package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository; //Import necesario para todos los repositorios

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    //arreglo para guardar los datos de los libros (ArrayList)
    private List<Libro> listaLibros = new ArrayList<>();

    //método para obtener todos los libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    //buscar un libro por su id
    public Libro buscarPorId(int id){
        //ciclo para recorrer la lista de libros
        for(Libro lib : listaLibros){
            if(lib.getId() == id){
                return lib;
            }
        }
        return null; //retornar un nulo en caso de que no consiga nada
    } 

    //buscar un libro por su isbn
    public Libro buscarPorisbn(String isbn){
        for(Libro lib : listaLibros){
            if(lib.getIsbn().equals(isbn)){
                return lib;
            }
        }
        return null;
    }

    //guardar libro
    public Libro guardarLibro(Libro lib){
        listaLibros.add(lib);
        return lib;
    }
    //actualizar libro
    public Libro actualizarLibro(Libro lib){
        int id = 0;
        int idPosicion = 0;
        //recorrer la lista para hasta encontrar el id y guardar su posición
        for(int i=0; i < listaLibros.size(); i++){
            //si los id coinciden
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        //modificar los datos de la lista
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setIsbn(lib.getIsbn());
        libro1.setTitulo(lib.getTitulo());
        libro1.setCantidadPaginas(lib.getCantidadPaginas());
        libro1.setEditorial(lib.getEditorial());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        listaLibros.set(idPosicion, libro1);
        return libro1;
    }
    //borrar libro
    public void eliminarLibro(int id){
        int idPosicion = 0;
         for(int i=0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getId() == id){
                idPosicion = i;
                break;
            }
         }
         if(idPosicion >= 0){
            listaLibros.remove(idPosicion);
         }

         //si queremos eliminar por id, borramos el código anterior y dejamos este sin comentarios
         /*
         listaLibros.removeIf(x -> x.getId() == id)
         */
    }
}
