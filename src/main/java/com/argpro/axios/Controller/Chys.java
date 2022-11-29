/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Controller;

import com.argpro.axios.Dto.DtoHys;
import com.argpro.axios.Entity.hys;
import com.argpro.axios.Security.Controller.Mensaje;
import com.argpro.axios.Service.Shys;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"http://localhost:4200","https://axiostestap.web.app"})

@RequestMapping("/skills")
public class Chys {
    @Autowired
    Shys shys;
    
    @GetMapping("/lista")
    public ResponseEntity<List<hys>> list() {
        List<hys> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<hys> getById(@PathVariable("id") int id){
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        hys skills = shys.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHys dtoHys) {
        if (StringUtils.isBlank(dtoHys.getNomSkill())) {
            return new ResponseEntity(new Mensaje("Nombre es oblidatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNomSkill(dtoHys.getNomSkill())) {
            return new ResponseEntity(new Mensaje("Habilidad existente"), HttpStatus.BAD_REQUEST);
        }
        hys skills = new hys(dtoHys.getNomSkill(), dtoHys.getPorcSkill(),dtoHys.getColorSkill(),dtoHys.getImgSkill());
        shys.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad guardada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHys dtoHys) {
        if (!shys.existsById(id))
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        
        if (shys.existsByNomSkill(dtoHys.getNomSkill()) && shys.getByNomSkill(dtoHys.getNomSkill()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Habilidad existente"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoHys.getNomSkill()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        

        hys skills = shys.getOne(id).get();
        skills.setNomSkill(dtoHys.getNomSkill());
        skills.setPorcSkill((dtoHys.getPorcSkill()));
        skills.setColorSkill((dtoHys.getColorSkill()));
        skills.setImgSkill((dtoHys.getImgSkill()));

        shys.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        shys.delete(id);

        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);

    }
    
}
