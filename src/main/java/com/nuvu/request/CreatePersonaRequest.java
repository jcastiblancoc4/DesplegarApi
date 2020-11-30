package com.nuvu.request;

import com.nuvu.entity.Tarjeta;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePersonaRequest {
	
    private String cedula;
    private String nombre;
    private String apellido;
    private List<Tarjeta> tarjetas;

}
