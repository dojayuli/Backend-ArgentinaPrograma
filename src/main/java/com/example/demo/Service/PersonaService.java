
package com.example.demo.Service;

import com.example.demo.Entity.Persona;
import com.example.demo.Interface.PersonaInterface;
import com.example.demo.Repository.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements PersonaInterface {
@Autowired PersonaRepo personaRepo;
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona=personaRepo.findAll();
        return persona;
       
    }

    @Override
    public void save(Persona persona) {
    personaRepo.save(persona);
    }

    @Override
    public void delete(Long id) {
     personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
     Persona persona=personaRepo.findById(id).orElse(null);
     return persona;
        
    }
    
}
