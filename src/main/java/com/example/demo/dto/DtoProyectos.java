/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;
import java.util.GregorianCalendar;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Yuli
 */
public class DtoProyectos {

    @NotBlank
    private String tituloProyecto;
    private GregorianCalendar fechaProyecto;
    private String descripcionProyecto;
    private String linkProyecto;
    private String imgProyecto;

    public DtoProyectos() {
    }

    public DtoProyectos(String tituloProyecto, GregorianCalendar fechaProyecto, String descripcionProyecto, String linkProyecto, String imgProyecto) {
        this.tituloProyecto = tituloProyecto;
        this.fechaProyecto = fechaProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.linkProyecto = linkProyecto;
        this.imgProyecto = imgProyecto;
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

