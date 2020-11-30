package com.nuvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nuvu.entity.Persona;

/**
 *
 * @author Juan Pablo Castiblan
 */
public interface PersonaRepository extends JpaRepository<Persona, Long>{
            
}
