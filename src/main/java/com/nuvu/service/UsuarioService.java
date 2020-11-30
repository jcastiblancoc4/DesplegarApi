package com.nuvu.service;

import com.nuvu.entity.Usuario;
import com.nuvu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo Castiblan
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepositori;
    
    public boolean validarUsuario(String usuario, String contraseña){
      for(Usuario u: usuarioRepositori.findAll()){
          if(u.getContraseña().equals(contraseña) && u.getUsuario().equals(usuario)){
              return true;
          }
      }
       return false;
    }        
    
}
