/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argpro.axios.Repository;

import com.argpro.axios.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Rhys extends JpaRepository<hys, Integer> {
    Optional<hys> findByNomSkill(String nomSkill);
    public boolean existsByNomSkill(String nomSkill);
    
    
}
