/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Service;

import com.argpro.axios.Entity.Educ;
import com.argpro.axios.Repository.REduc;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEduc {
    @Autowired
    REduc rEduc;
    
    public List<Educ> list(){
        return rEduc.findAll();
    }
    
    public Optional<Educ> getOne(int id){
        return rEduc.findById(id);
    }
    
    public Optional<Educ> getByNomEduc(String nomEduc){
        return rEduc.findByNomEduc(nomEduc);
    }
    
    public void save(Educ educ){
        rEduc.save(educ);
    }
    
    public void delete(int id){
        rEduc.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEduc.existsById(id);
    }
    
    public boolean existsByNomEduc(String nomEduc){
        return rEduc.existsByNomEduc(nomEduc);
    }
    
}
