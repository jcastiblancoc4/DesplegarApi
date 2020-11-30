package com.nuvu.request;

import com.nuvu.entity.Tarjeta;
import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePersonaRequest{

    @NotNull(message = "Student Id is required")
    private Long id;

    private String cedula;
    private String nombre;
    private String apellido;
    private List<Tarjeta> tarjetas;

}
