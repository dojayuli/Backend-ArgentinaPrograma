
package com.example.demo.Controller;

import com.example.demo.Entity.Persona;
import com.example.demo.Service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControl {
    @Autowired PersonaService ipersonaService;
 @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
       ipersonaService.save(persona);
       return "La persona fue creada correctamente";
    }
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.delete(id);
        return("La persona fue eliminada correctamente");
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,@RequestBody Persona persona){
        Persona persona1 = ipersonaService.findPersona(id);

        persona1.setNombre(persona.getNombre());
        persona1.setApellido(persona.getApellido());
        persona1.setImg(persona.getImg());
        persona1.setDescripcion(persona.getDescripcion());
        persona1.setTitulo(persona.getTitulo());

        ipersonaService.save(persona1);
        return persona1;
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }   
}
