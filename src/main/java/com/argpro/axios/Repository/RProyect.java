/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argpro.axios.Repository;

import com.argpro.axios.Entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyect extends JpaRepository<Proyect, Integer> {
    public Optional<Proyect>findByNomProyect(String nomProyect);
    public boolean existsByNomProyect(String nomProyect);
    
}
