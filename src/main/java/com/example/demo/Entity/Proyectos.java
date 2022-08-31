/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Entity;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Yuli
 */

@Entity
public class Proyectos {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50, message = "Titulo no valido" )
    private String tituloProyecto;
    @NotNull
    private GregorianCalendar fechaProyecto;
    @NotNull
    @Size(min = 10, max = 500, message = "Descripcion no valida" )
    private String descripcionProyecto;
    @NotNull
    private String linkProyecto;
    @NotNull
    private String imgProyecto;

    public Proyectos() {
    }

    public Proyectos(String tituloProyecto, GregorianCalendar fechaProyecto, String descripcionProyecto, String linkProyecto, String imgProyecto) {
        this.tituloProyecto = tituloProyecto;
        this.fechaProyecto = fechaProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.linkProyecto = linkProyecto;
        this.imgProyecto = imgProyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloProyecto() {
        return tituloProyecto;
    }

    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    public GregorianCalendar getFechaProyecto() {
        return fechaProyecto;
    }

    public void setFechaProyecto(GregorianCalendar fechaProyecto) {
        this.fechaProyecto = fechaProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getLinkProyecto() {
        return linkProyecto;
    }

    public void setLinkProyecto(String linkProyecto) {
        this.linkProyecto = linkProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }
    
    
    
}

