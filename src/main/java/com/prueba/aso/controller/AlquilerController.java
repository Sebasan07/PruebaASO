package com.prueba.aso.controller;

import com.prueba.aso.repository.IAlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alquiler")
public class AlquilerController {

    @Autowired
    private IAlquilerRepository iAlquilerRepository;

    @PostMapping("/")

}
