package com.argpro.axios.Controller;

import com.argpro.axios.Dto.DtoExp;
import com.argpro.axios.Entity.ExpLaboral;
import com.argpro.axios.Security.Controller.Mensaje;

import com.argpro.axios.Service.SExp;
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
@RequestMapping("explab")
@CrossOrigin(origins = {"http://localhost:4200","https://axiostestap.web.app"})

public class CExp {

    @Autowired
    SExp sExp;

    @GetMapping("/lista")
    public ResponseEntity<List<ExpLaboral>> list() {
        List<ExpLaboral> list = sExp.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExpLaboral> getById(@PathVariable("id") int id){
        if(!sExp.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExpLaboral xp = sExp.getOne(id).get();
        return new ResponseEntity(xp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExp dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Nombre es oblidatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExp.existsByNombreE(dtoExp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }
        ExpLaboral xp = new ExpLaboral(dtoExp.getNombreE(), dtoExp.getDescripcionE());
        sExp.save(xp);
        return new ResponseEntity(new Mensaje("Experiencia guardada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExp dtoExp) {
        if (!sExp.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        if (sExp.existsByNombreE(dtoExp.getNombreE()) && sExp.getByNombreE(dtoExp.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getNombreE())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }

        ExpLaboral xp = sExp.getOne(id).get();
        xp.setNombreE(dtoExp.getNombreE());
        xp.setDescripcionE((dtoExp.getDescripcionE()));

        sExp.save(xp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExp.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        sExp.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }
}
