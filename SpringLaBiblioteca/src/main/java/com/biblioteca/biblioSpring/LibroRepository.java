/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.biblioteca.biblioSpring;

import java.util.List;
import models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Doctor32
 * Repositorio JPA. Aquí tenemos el CRUD. Gracias a Spring no 
 * tenemos que implementarlo.
 * El método findBycategoria lo hemos creado con el fin de añadir más
 * funcionalidad. Realmente no se nos ofrecía ese método.
 * La anotación query hace que este método sea JPA
 */
public interface LibroRepository extends JpaRepository<Libro, Long> {
   
    public List<models.Libro> findByAutor(String autor);
    
    public List<models.Libro> findByCategoria(String categoria);
    
    //@Query(value="SELECT id, titulo FROM Libro l")
    //public List<models.Libro> resumen();
    
    @Query(value="SELECT l FROM Libro l WHERE id>=?1 AND id<=?2")
    public List<models.Libro> fromTo(Long id1, Long id2);
    
    @Query(value="SELECT l.id, l.titulo FROM Libro l")
    public List<Object[]> simple ();
    
}
