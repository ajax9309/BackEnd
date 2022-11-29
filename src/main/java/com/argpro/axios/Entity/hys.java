/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class hys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomSkill;
    private int porcSkill;
    private String colorSkill;
    private String imgSkill;

    public hys() {
    }

    public hys(String nomSkill, int porcSkill, String colorSkill, String imgSkill) {
        this.nomSkill = nomSkill;
        this.porcSkill = porcSkill;
        this.colorSkill = colorSkill;
        this.imgSkill = imgSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSkill() {
        return nomSkill;
    }

    public void setNomSkill(String nomSkill) {
        this.nomSkill = nomSkill;
    }

    public int getPorcSkill() {
        return porcSkill;
    }

    public void setPorcSkill(int porcSkill) {
        this.porcSkill = porcSkill;
    }

    public String getColorSkill() {
        return colorSkill;
    }

    public void setColorSkill(String colorSkill) {
        this.colorSkill = colorSkill;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }

    

}



