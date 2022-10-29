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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    
    @NotNull
    @Size(min= 1, max = 50, message="no cumple minimo")
    private String nombre;
    
    @NotNull
    @Size(min= 1, max = 50, message="no cumple minimo")
    private String apellido;
    
    @NotNull
    @Size(min= 1, max = 255, message="no cumple minimo")
    private String img;
    
    @NotNull
    @Size(min= 1, max = 255, message="no cumple minimo")
    private String descrip;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String descrip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descrip = descrip;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
