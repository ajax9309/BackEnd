/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity


public class Proyect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
  
    @NotNull
    @Size(min= 1, max = 50, message="no cumple minimo")
    private String nomProyect;
    
    @NotNull
    @Size(min= 1, max = 255, message="no cumple minimo")
    private String imgProyect;
    
    @NotNull
    @Size(min= 1, max = 255, message="no cumple minimo")
    private String descProyect;

    public Proyect() {
    }

    public Proyect(String nomProyect, String imgProyect, String descProyect) {
        this.nomProyect = nomProyect;
        this.imgProyect = imgProyect;
        this.descProyect = descProyect;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
