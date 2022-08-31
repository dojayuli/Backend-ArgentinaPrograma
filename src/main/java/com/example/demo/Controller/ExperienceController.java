/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;
import com.example.demo.Entity.Experience;
import com.example.demo.Service.ExperienceService;
import com.example.demo.dto.DtoExperience;
import com.example.demo.security.controller.Mensaje;
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
@RequestMapping("experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list() {

        List<Experience> list = experienceService.list();

        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExp){
    
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(experienceService.existsByNombre(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        Experience experience = new Experience(dtoExp.getNombreExp(), dtoExp.getDescripcionExp(), dtoExp.getImgExperience());
        
        experienceService.save(experience);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDate(@PathVariable("id") int id, @RequestBody DtoExperience dtoExp){
    
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(experienceService.existsByNombre(dtoExp.getNombreExp()) && experienceService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experience experience = experienceService.getOne(id).get();
        experience.setNombreExp(dtoExp.getNombreExp());
        experience.setDescripcionExp(dtoExp.getDescripcionExp());
        experience.setImgExperience(dtoExp.getImgExperience());
        
        experienceService.save(experience);
        
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    
        
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        experienceService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
}



