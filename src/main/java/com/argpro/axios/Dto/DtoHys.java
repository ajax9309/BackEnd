/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHys {
    @NotBlank
    private String nomSkill;
    @NotBlank
    private int porcSkill;
    @NotBlank
    private String colorSkill;
    @NotBlank
    private String imgSkill;
    
    public DtoHys() {
    }

    public DtoHys(String nomSkill, int porcSkill, String colorSkill, String imgSkill) {
        this.nomSkill = nomSkill;
        this.porcSkill = porcSkill;
        this.colorSkill = colorSkill;
        this.imgSkill = imgSkill;
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
