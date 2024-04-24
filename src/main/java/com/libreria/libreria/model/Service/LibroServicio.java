
package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Libro;
import com.libreria.libreria.model.Repository.LibroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio implements ILibroServicio {
   @Autowired
   private LibroRepositorio libroRepositorio;

   public LibroServicio() {
   }

   public List<Libro> listarLibros() {
      return (List<Libro>)this.libroRepositorio.findAll();
   }

   public void guardarLibro(Libro libro) {
      this.libroRepositorio.save(libro);
   }

   public Libro buscarPorIdL(int id) {
      return (Libro)this.libroRepositorio.findById(id).orElse((Libro)null);
   }

   public void eliminarlibro(int id) {
      this.libroRepositorio.deleteById(id);
   }
}
