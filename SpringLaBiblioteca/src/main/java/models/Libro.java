/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Doctor32
 * Modelo libro
 * Gracias a que en principio cogimos la dependencia de Lombok
 * solo tenemos que poner las anotaciones.
 * Teniendo los atributos el mismo nombre que los de la columna
 * de la tabla, se mapea todo de manera automática.
 */

@Data
@Entity
@Table(name="libros")
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private String categoria;
    private String ISBN;
    private String edicion;
}
