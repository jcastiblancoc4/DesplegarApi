/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.service;

import com.nuvu.entity.Tarjeta;
import com.nuvu.repository.TarjetaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo Castiblan
 */
@Service
public class TarjetaService {

    @Autowired
    TarjetaRepository tarjetaRepository;

    public Tarjeta createTarjeta(Tarjeta tarjeta) {
        tarjeta = tarjetaRepository.save(tarjeta);
        return tarjeta;
    }

    public void deleteTarjetas(List<Tarjeta> tarjetas) {
        tarjetas.stream().forEach(tar -> {
            tarjetaRepository.deleteById(tar.getId());
        });
    }

    public String deleteTarjeta(Long id) {
        tarjetaRepository.deleteById(id);
        return "Card has been deleted successfully";
    }
}
