package com.prueba.aso.service.impl;

import com.prueba.aso.entities.Alquiler;
import com.prueba.aso.repository.IAlquilerRepository;
import com.prueba.aso.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    private IAlquilerRepository iAlquilerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Alquiler> findAll() {
        return iAlquilerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Alquiler> findAll(Pageable pageable) {
        return iAlquilerRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alquiler> findById(Integer id) {
        return iAlquilerRepository.findById(id);
    }

    @Override
    @Transactional
    public Alquiler save(Alquiler alquiler) {
        return iAlquilerRepository.save(alquiler);
    }

    @Override
    public void deleteById(Integer id) {
        iAlquilerRepository.deleteById(id);
    }
}
