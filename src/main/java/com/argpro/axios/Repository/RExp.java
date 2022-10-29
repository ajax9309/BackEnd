/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argpro.axios.Repository;

import com.argpro.axios.Entity.ExpLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExp extends JpaRepository<ExpLaboral, Integer>{
    public Optional<ExpLaboral>findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
