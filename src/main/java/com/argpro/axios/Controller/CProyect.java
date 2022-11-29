/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Controller;

import com.argpro.axios.Dto.DtoProyect;
import com.argpro.axios.Entity.Proyect;
import com.argpro.axios.Security.Controller.Mensaje;
import com.argpro.axios.Service.SProyect;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200","https://axiostestap.web.app"})
public class CProyect {
    @Autowired
    SProyect sProyect;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = sProyect.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyect> getById(@PathVariable("id") int id){
        if(!sProyect.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyect proyect = sProyect.getOne(id).get();
        return new ResponseEntity(proyect, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyect.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);

        }
        sProyect.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyect dtoProyect) {
        if (StringUtils.isBlank(dtoProyect.getNomProyect())) {
            return new ResponseEntity(new Mensaje("Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyect.existsByNomProyect(dtoProyect.getNomProyect())) {
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect = new Proyect(
                dtoProyect.getNomProyect(), dtoProyect.getDescProyect(),dtoProyect.getImgProyect()
        );
        sProyect.save(proyect);
        return new ResponseEntity(new Mensaje("Registro creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyect dtoProyect) {
        if (!sProyect.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }
        if (sProyect.existsByNomProyect(dtoProyect.getNomProyect()) && sProyect.getByNomProyect(dtoProyect.getNomProyect()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyect.getNomProyect())) {
            return new ResponseEntity(new Mensaje("Nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect=sProyect.getOne(id).get();
        proyect.setNomProyect(dtoProyect.getNomProyect());
        proyect.setDescProyect(dtoProyect.getDescProyect());
        proyect.setImgProyect(dtoProyect.getImgProyect());
        
        sProyect.save(proyect);
        return new ResponseEntity(new Mensaje ("Registro guardado"),HttpStatus.OK);
        
        
    }
    
}
