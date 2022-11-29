/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyect {
    @NotBlank
    private String nomProyect;
    @NotBlank
    private String descProyect;
    @NotBlank
    private String imgProyect;

    public DtoProyect() {
    }

    public DtoProyect(String nomProyect, String descProyect, String imgProyect) {
        this.nomProyect = nomProyect;
        this.descProyect = descProyect;
        this.imgProyect = imgProyect;
    }

    
    public String getNomProyect() {
        return nomProyect;
    }

    public void setNomProyect(String nomProyect) {
        this.nomProyect = nomProyect;
    }

    public String getDescProyect() {
        return descProyect;
    }

    public void setDescProyect(String descProyect) {
        this.descProyect = descProyect;
    }
    
    public String getImgProyect() {
        return imgProyect;
    }

    public void setImgProyect(String imgProyect) {
        this.imgProyect = imgProyect;
    }

    
    
}
