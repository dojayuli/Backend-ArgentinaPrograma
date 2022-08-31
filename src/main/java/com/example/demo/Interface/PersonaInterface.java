
package com.example.demo.Interface;

import com.example.demo.Entity.Persona;
import java.util.List;


public interface PersonaInterface {
    
    //Trae Personas
    public List<Persona> getPersona();
    
    //guardar personas
    public void save(Persona persona);
 
 //borrar personas    
    public void delete(Long id);
  
   //edita Personas
    public Persona findPersona(Long id);
}

