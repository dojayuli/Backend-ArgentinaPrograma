/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import javax.validation.constraints.NotBlank;


/**
 *
 * @author Usuario
 */
public class DtoExperience {
     @NotBlank
    private String nombreExp;
    private String descripcionExp;
    private String imgExperience;

    public DtoExperience() {
    }

    public DtoExperience(String nombreExp, String descripcionExp, String imgExperience) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.imgExperience = imgExperience;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getImgExperience() {
        return imgExperience;
    }

    public void setImgExperience(String imgExperience) {
        this.imgExperience = imgExperience;
    }
    
    
}
