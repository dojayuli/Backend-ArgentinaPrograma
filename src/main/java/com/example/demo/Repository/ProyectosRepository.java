/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;
import com.example.demo.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yuli
 */

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Long> {

    public Optional<Proyectos> findByTituloProyecto(String tituloProyecto);
    public boolean existsByTituloProyecto(String tituloProyectoString);
}

/**
 *
 * @author Usuario
 */
