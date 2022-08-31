/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;
import javax.validation.constraints.NotBlank;

public class DtoEducation {

    @NotBlank
    private String nombreE;
    private String descripcionE;
    private String imgEducation;



    public DtoEducation() {
    }

    public DtoEducation(String nombreE, String descripcionE, String imgEducation) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgEducation = imgEducation;

    }


    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImgEducation() {
        return imgEducation;
    }

    public void setImgEducation(String imgEducation) {
        this.imgEducation = imgEducation;
    }




}


