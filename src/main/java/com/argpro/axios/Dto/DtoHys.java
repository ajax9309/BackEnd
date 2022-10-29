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

    
    public DtoHys() {
    }

    public DtoHys(String nomSkill, int porcSkill) {
        this.nomSkill = nomSkill;
        this.porcSkill = porcSkill;
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
    
    
}
