package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor; //Crea método constructor con todos los parametros 
import lombok.Data; //Genera Getter, Setter, ToString, Encampsulamiento de variables
import lombok.NoArgsConstructor; //crea el constructor vacio

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    private int id;
    private String isbn; //Identificador único tipo DNI del libro
    private String titulo;
    private int cantidadPaginas;
    private String editorial;
    private int fechaPublicacion;

}
