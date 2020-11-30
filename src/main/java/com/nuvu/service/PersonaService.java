package com.nuvu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuvu.entity.Persona;
import com.nuvu.entity.Tarjeta;
import com.nuvu.request.CreatePersonaRequest;
import com.nuvu.request.UpdatePersonaRequest;
import com.nuvu.repository.PersonaRepository;
import com.nuvu.repository.TarjetaRepository;

/**
 *
 * @author Juan Pablo Castiblan
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    TarjetaRepository tarjetaRepository;

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Persona createPersona(CreatePersonaRequest createPersonaRequest) {
        Persona persona = new Persona(createPersonaRequest);
        persona = personaRepository.save(persona);
        return persona;

    }

    public Persona updatePersona(UpdatePersonaRequest updatePersonaRequest) {

        Persona persona = personaRepository.findById(updatePersonaRequest.getId()).get();

        if (updatePersonaRequest.getCedula() != null
                && !updatePersonaRequest.getCedula().isEmpty()) {
            persona.setCedula(updatePersonaRequest.getCedula());
        }
        if (updatePersonaRequest.getNombre() != null
                && !updatePersonaRequest.getNombre().isEmpty()) {
            persona.setNombre(updatePersonaRequest.getNombre());
        }
        if (updatePersonaRequest.getApellido() != null
                && !updatePersonaRequest.getApellido().isEmpty()) {
            persona.setApellido(updatePersonaRequest.getApellido());
        }
        if (updatePersonaRequest.getTarjetas() != null
                && !updatePersonaRequest.getTarjetas().isEmpty()) {

            updatePersonaRequest.getTarjetas().stream().forEach(tar -> {

                Tarjeta tarjeta = tarjetaRepository.findById(tar.getId()).get();

                if (tar.getMarca() != null && !tar.getMarca().isEmpty()) {
                    tarjeta.setMarca(tar.getMarca());
                }
                if (tar.getBanco() != null && !tar.getBanco().isEmpty()) {
                    tarjeta.setBanco(tar.getBanco());
                }
                if (tar.getNumero() != null && !tar.getNumero().isEmpty()) {
                    tarjeta.setNumero(tar.getNumero());
                }
                if (tar.getFechaCaducidad() != null && !tar.getFechaCaducidad().isEmpty()) {
                    tarjeta.setFechaCaducidad(tar.getFechaCaducidad());
                }
                if (tar.getCcv() != null) {
                    tarjeta.setCcv(tar.getCcv());
                }
                if (tar.getCupo() != null) {
                    tarjeta.setCupo(tar.getCupo());
                }
                tarjeta = tarjetaRepository.save(tarjeta);
            });

        }

        persona = personaRepository.save(persona);
        return persona;
    }

    public Persona personaId(Long id) {
        return personaRepository.getOne(id);
    }

    public String deletePerson(long id) {
        personaRepository.deleteById(id);
        return "Person has been deleted successfully";
    }

}
