package com.libreria.libreria.model.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(
   name = "libro"
)
@Data
public class Libro {
   @Id
   private int idLibro;
   private String titulo;
   private String autor;
   private int anioPublicacion;

}
