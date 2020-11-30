/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nuvu.entity.Usuario;

/**
 *
 * @author Juan Pablo Castiblan
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

     
}
