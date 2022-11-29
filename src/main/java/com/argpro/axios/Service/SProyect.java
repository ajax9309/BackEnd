/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Service;

import com.argpro.axios.Entity.Proyect;
import com.argpro.axios.Repository.RProyect;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class SProyect {
    @Autowired
    RProyect rProyect;
    
    public List<Proyect> list(){
        return rProyect.findAll();
    }
    
    public Optional<Proyect> getOne(int id){
        return rProyect.findById(id);
    }
    
    public Optional<Proyect> getByNomProyect(String nomProyect){
        return rProyect.findByNomProyect(nomProyect);
    }
    
    public void save(Proyect proyect){
        rProyect.save(proyect);
    }
    
    public void delete(int id){
        rProyect.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyect.existsById(id);
    }
    
    public boolean existsByNomProyect(String nomProyect){
        return rProyect.existsByNomProyect(nomProyect);
    }
    
}
