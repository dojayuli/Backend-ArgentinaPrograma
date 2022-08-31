
 
package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "longitud incorrecta")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "longitud incorrecta")
    private String apellido;


    @Size(min = 1, max = 50, message = "longitud incorrecta")
    private String img; 
    @NotNull
    @Size(min = 1, max = 500, message = "longitud incorrecta")
    private String descripcion;
    
    @NotNull
    @Size(min = 1, max = 50, message = "longitud incorrecta")
    private String titulo;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String descripcion, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
