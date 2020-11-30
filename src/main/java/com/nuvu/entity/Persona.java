package com.nuvu.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.nuvu.request.CreatePersonaRequest;
import java.util.List;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @OneToMany(mappedBy = "persona")
    private List<Tarjeta> tarjetas;

    public Persona(CreatePersonaRequest createPersonaRequest) {
        this.cedula = createPersonaRequest.getCedula();
        this.nombre = createPersonaRequest.getNombre();
        this.apellido = createPersonaRequest.getApellido();
        this.tarjetas = createPersonaRequest.getTarjetas();
    }
}
