/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Service;

import com.argpro.axios.Entity.ExpLaboral;
import com.argpro.axios.Repository.RExp;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExp {
    @Autowired
    RExp rExp;
    public List<ExpLaboral> list(){
        return rExp.findAll();
    }
    
    public Optional<ExpLaboral> getOne(int id){
        return rExp.findById(id);
    }
    
    public Optional<ExpLaboral> getByNombreE(String nombreE){
        return rExp.findByNombreE(nombreE);
    }
    
    public void save(ExpLaboral xp){
        rExp.save(xp);
    }
    
    public void delete(int id){
        rExp.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExp.existsById(id);    
    }
    
    public boolean existsByNombreE(String nombreE){
        return rExp.existsByNombreE(nombreE);
    }
    
}
