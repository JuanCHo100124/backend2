package com.libreria.libreria.controlller;
import com.libreria.libreria.model.Entity.Libro;
import com.libreria.libreria.model.Service.ILibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/paginas/"})
public class LibroController {
   @Autowired
   private ILibroServicio libroServicio;

   public LibroController() {
   }

   @GetMapping({"/"})
   public String listarLibros(Model modelo) {
      List<Libro> listadoLibros = this.libroServicio.listarLibros();
      modelo.addAttribute("libros", listadoLibros);
      return "/paginas/listar";
   }

   @PostMapping({"/create"})
   public String crearLibro(@ModelAttribute Libro libro, Model modelo) {
      this.libroServicio.guardarLibro(libro);
      return "redirect:/paginas/";
   }

   @PutMapping({"/edit/{id}"})
   public String editarLibro(@PathVariable("id") int idLibro, @ModelAttribute Libro libro, Model modelo) {
      libro.setIdLibro(idLibro);
      this.libroServicio.guardarLibro(libro);
      return "redirect:/paginas/";
   }

   @DeleteMapping({"/delete/{id}"})
   public String eliminarLibro(@PathVariable("id") int idLibro) {
      this.libroServicio.eliminarlibro(idLibro);
      return "redirect:/paginas/";
   }
}
