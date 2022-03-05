package com.biblioteca.biblioSpring;

import java.util.List;
import models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author Doctor32
 * Este es nuestro Rest controller. Va a devolver como respuesta
 * datos de tipo JSON.
 */


/**
 * Esta es nuestra url base. A partir de esta montaremos los demás
 * endpoints.
 * Autowired nos permite enlazar el controller con la clase Libro.
 * Creamos los end points con la anotación GetMapping.
 * Todos los métodos CRUD los tenemos a disposición gracias a
 * la instanciación de LibroRepository.
 * IMP. Hay que añadirle una barra final al endpoint
 */
@RestController
@RequestMapping("/theworld")
public class LibroController {
    
/**
 * Métodos.
 * findAll(). Hace una consulta a la BD, compacta la info en JSON y devuelve
 * la librería.
 * getById. Hace la consulta a la BD, compacta la info y devuelve un libro
 * según el id.
 */
    
    @Autowired
    private LibroRepository almacen;

    @GetMapping("/")
    public List<models.Libro> biblio() {
        return almacen.findAll();
    }

    @GetMapping("/only")
    public List<Object[]> simple() {
        return almacen.simple();
    }
    
    @GetMapping("/{id}")
    public models.Libro libro(@PathVariable Long id){
        System.out.println("Sacando libro de la biblioteca... " + id);
        Libro elLibro = almacen.getById(id);  
        System.out.println(elLibro);
        return elLibro;
    }

    @GetMapping("/aut/{autor}")
    public List<models.Libro> autor(@PathVariable String autor){
        System.out.println("Sacando libro por autor... " + autor);
        List<models.Libro> respuestaAutor = almacen.findByAutor(autor);
        return respuestaAutor;
    }

    @GetMapping("/cat/{categoria}")
    public List<models.Libro> categoria(@PathVariable String categoria){
        System.out.println("Sacando libro por categoría... " + categoria);
        List<models.Libro> respuestaCat = almacen.findByCategoria(categoria);
        return respuestaCat;
    }
    
    @GetMapping("/fromTo/{id1}/{id2}")
    public List<models.Libro> fromTo(@PathVariable Long id1, @PathVariable Long id2){
        return almacen.fromTo(id1, id2);
    }
}
