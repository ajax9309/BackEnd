/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoEduc {
    @NotBlank
    private String nomEduc;
    @NotBlank
    private String descEduc;

    public DtoEduc() {
    }

    public DtoEduc(String nomEduc, String descEduc) {
        this.nomEduc = nomEduc;
        this.descEduc = descEduc;
    }
    
    
}
