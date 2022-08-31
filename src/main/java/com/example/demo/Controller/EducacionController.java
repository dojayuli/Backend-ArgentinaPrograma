/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;
import com.example.demo.Entity.Education;
import com.example.demo.Service.EducationService;
import com.example.demo.dto.DtoEducation;
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
@RequestMapping("education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired
    EducationService sEducation;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list() {

        List<Education> list = sEducation.list();

        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEdu){
    
        if(StringUtils.isBlank(dtoEdu.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sEducation.existsByNombre(dtoEdu.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        Education education = new Education(dtoEdu.getNombreE(), dtoEdu.getDescripcionE(), dtoEdu.getImgEducation());
        
        sEducation.save(education);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDate(@PathVariable("id") int id, @RequestBody DtoEducation dtoEdu){
    
        if(!sEducation.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sEducation.existsByNombre(dtoEdu.getNombreE()) && sEducation.getByNombreE(dtoEdu.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoEdu.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Education education = sEducation.getOne(id).get();
        education.setNombreE(dtoEdu.getNombreE());
        education.setDescripcionE(dtoEdu.getDescripcionE());
        education.setImgEducation(dtoEdu.getImgEducation());
        
        sEducation.save(education);
        
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    
        
        if(!sEducation.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sEducation.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!sEducation.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
}

