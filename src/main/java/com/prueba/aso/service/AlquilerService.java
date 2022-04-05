package com.prueba.aso.service;

import com.prueba.aso.entities.Alquiler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AlquilerService {

    public List<Alquiler> findAll(); //Devuelve un Iterable del objeto Alquiler

    public Page<Alquiler> findAll(Pageable pageable);

    public Optional<Alquiler> findById(Integer id);

    public Alquiler save(Alquiler alquiler);

    public void deleteById(Integer id);
}
