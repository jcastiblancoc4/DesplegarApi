package com.nuvu.response;
import com.nuvu.entity.Persona;

import com.nuvu.entity.Tarjeta;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonaResponse {

	private long id;

    private String cedula;
    private String nombre;
    private String apellido;
    private List<Tarjeta> tarjetas;
    
	public PersonaResponse (Persona persona) {
		this.id = persona.getId();
		this.cedula = persona.getCedula();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
                this.tarjetas=persona.getTarjetas();
	}

}