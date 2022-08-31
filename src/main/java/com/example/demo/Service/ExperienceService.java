/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;
import com.example.demo.Entity.Experience;
import com.example.demo.Repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    public List<Experience> list(){

        return experienceRepository.findAll();
    }

    public Optional<Experience> getOne(int id){

        return experienceRepository.findById(id);
    }

    public Optional<Experience> getByNombreExp(String nombreExp){
        return experienceRepository.findByNombreExp(nombreExp);
    }

    public void save(Experience experience){

        experienceRepository.save(experience);
    }

    public void delete(int id){

        experienceRepository.deleteById(id);
    }

    public boolean existsById(int id){

        return experienceRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreExp){

        return experienceRepository.existsByNombreExp(nombreExp);
    }
}

/**
 *
 * @author Usuario
 */

