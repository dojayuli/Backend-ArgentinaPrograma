/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;
import com.example.demo.Entity.Proyectos;
import com.example.demo.Service.ProyectosService;
import com.example.demo.dto.DtoProyectos;
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

/**
 *
 * @author Yuli
 */

@RestController
@RequestMapping("proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    
    
    @Autowired 
    ProyectosService proyectoService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyectos>> list() {

        List<Proyectos> list = proyectoService.list();

        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos){
    
        if(StringUtils.isBlank(dtoProyectos.getTituloProyecto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(proyectoService.existsByNombre(dtoProyectos.getTituloProyecto()))
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        
        Proyectos proyecto = new Proyectos(dtoProyectos.getTituloProyecto(),dtoProyectos.getFechaProyecto(),dtoProyectos.getDescripcionProyecto(),dtoProyectos.getLinkProyecto(),dtoProyectos.getImgProyecto());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDate(@PathVariable("id") Long id, @RequestBody DtoProyectos dtoProyecto){
    
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(proyectoService.existsByNombre(dtoProyecto.getTituloProyecto()) && proyectoService.getByTitulo(dtoProyecto.getTituloProyecto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoProyecto.getTituloProyecto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        
     
       Proyectos proyecto = proyectoService.getOne(id).get();
       proyecto.setTituloProyecto(dtoProyecto.getTituloProyecto());
       proyecto.setFechaProyecto(dtoProyecto.getFechaProyecto());
       proyecto.setDescripcionProyecto(dtoProyecto.getDescripcionProyecto());
       proyecto.setLinkProyecto(dtoProyecto.getLinkProyecto());
       proyecto.setImgProyecto(dtoProyecto.getImgProyecto());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
    
        
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") Long id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            Proyectos proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
}



