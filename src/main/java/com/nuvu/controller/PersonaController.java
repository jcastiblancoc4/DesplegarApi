package com.nuvu.controller;

import com.nuvu.entity.Persona;
import com.nuvu.entity.Tarjeta;
import com.nuvu.service.PersonaService;
import com.nuvu.service.TarjetaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nuvu.response.PersonaResponse;
import java.util.ArrayList;
import com.nuvu.request.CreatePersonaRequest;
import com.nuvu.request.UpdatePersonaRequest;
/**
 *
 * @author Juan Pablo Castiblan
 */
@RestController
//@RequestMapping("/api/persona/")
public class PersonaController {

    @Autowired
    PersonaService personaService;
    @Autowired
    TarjetaService tarjetaService;

    @GetMapping("getAll")
    public List<PersonaResponse> getAllPersonas() {
        List<Persona> personaList = personaService.getAllPersonas();
        List<PersonaResponse> personaResponseList = new ArrayList<>();
        personaList.stream().forEach(persona -> {
            personaResponseList.add(new PersonaResponse(persona));
        });

        return personaResponseList;
    }

    @PostMapping("create")
    public PersonaResponse createPersona(@RequestBody CreatePersonaRequest createPersonaRequest) {
        Persona persona = personaService.createPersona(createPersonaRequest);
        List<Tarjeta> tarjeta = createPersonaRequest.getTarjetas();
        tarjeta.stream().forEach(tar -> {
            tar.setPersona(persona);
            tarjetaService.createTarjeta(tar);
        });
        return new PersonaResponse(persona);
    }

    @PutMapping("update")
    public PersonaResponse updatePersona(@RequestBody UpdatePersonaRequest updatepersonaRequest) {
        Persona persona = personaService.updatePersona(updatepersonaRequest);

        return new PersonaResponse(persona);
    }

    @DeleteMapping("delete")
    public String deletePersona(@RequestParam long id) {
        Persona persona = personaService.personaId(id);
        tarjetaService.deleteTarjetas(persona.getTarjetas());
        return personaService.deletePerson(id);
    }
    
    @DeleteMapping("delete/tarjeta")
    public String deleteTarjeta(@RequestParam long id) {
     return tarjetaService.deleteTarjeta(id);
    }

}
