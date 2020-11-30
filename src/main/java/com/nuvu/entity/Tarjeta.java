package com.nuvu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Juan Pablo Castiblan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@ToString
@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column( name = "marca")
    private String marca;
    @Column( name = "banco")
    private String banco;
    @Column( name = "numero")
    private String numero;
    @Column( name = "fecha_caducidad")
    private String fechaCaducidad;
    @Column( name = "ccv")
    private Integer ccv;
    @Column( name = "cupo")
    private Integer cupo;
    @JsonIgnore
    @JoinColumn(name = "id_persona")
    @ManyToOne
    private Persona persona;

}
