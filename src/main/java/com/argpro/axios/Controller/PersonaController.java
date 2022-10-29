/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argpro.axios.Controller;

import com.argpro.axios.Dto.DtoPersona;
import com.argpro.axios.Entity.Persona;
import com.argpro.axios.Security.Controller.Mensaje;
import com.argpro.axios.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aleoh
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//        if (!personaService.existsById(id)) {
//            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
//
//        }
//        personaService.delete(id);
//        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
//
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {
//        if (StringUtils.isBlank(dtoPersona.getNombre())) {
//            return new ResponseEntity(new Mensaje("Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if (personaService.existsByNombre(dtoPersona.getNombre())) {
//            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
//        }
//        Persona persona = new Persona(
//                dtoPersona.getNombre(), dtoPersona.getDescrip()
//        );
//        personaService.save(persona);
//        return new ResponseEntity(new Mensaje("Registro creado"), HttpStatus.OK);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }
        if (personaService.existsByNombre(dtoPersona.getNombre()) && personaService.getByNombre(dtoPersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setDescrip(dtoPersona.getDescrip());
        persona.setImg(dtoPersona.getImg());

        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Registro guardado"), HttpStatus.OK);

    }

}
