/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Service;

import com.argpro.axios.Entity.hys;
import com.argpro.axios.Repository.Rhys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Shys {
    @Autowired
    Rhys rhys;
    
    public List<hys> list(){
        return rhys.findAll();    
    }
    
    public Optional<hys> getOne(int id){
        return rhys.findById(id);
    }
    
    public Optional<hys> getByNomSkill(String nomSkill){
        return rhys.findByNomSkill(nomSkill);
    }
    
    public void save(hys HyS){
        rhys.save (HyS);
    }
    
    public void delete(int id){
        rhys.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    
    public boolean existsByNomSkill(String nomSkill){
        return rhys.existsByNomSkill(nomSkill);
    }
    
}
