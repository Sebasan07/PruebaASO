package com.prueba.aso.controller;

import com.prueba.aso.entities.Alquiler;

import com.prueba.aso.service.AlquilerService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/alquiler")
public class AlquilerController {

    private final Log LOGGER = LogFactory.getLog(AlquilerController.class);

    @Autowired
    private AlquilerService alquilerService;

    @GetMapping(value = "/ver-alquileres", produces =MediaType.APPLICATION_JSON_VALUE)
    public List<Alquiler> verAlquileres() {
        List<Alquiler> alquileres = alquilerService.findAll();

        alquileres.stream()
                .forEach(alq -> LOGGER.info("Alquiler con id=1" + alq.getId()));

        return alquileres;
    }

    @PostMapping(path = "/crear-alquiler", consumes = "application/json")
    public ResponseEntity<?> crearAlquiler(@RequestBody Alquiler alquiler) {
        alquilerService.save(alquiler);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/editar-alquiler", consumes = "application/json")
    public ResponseEntity<?> editar(@RequestBody Alquiler alquiler) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alquilerService.save(alquiler));
    }

    @DeleteMapping("/eliminar/{id-alquiler}")
    public ResponseEntity<?> eliminar(@PathVariable(value="id-alquiler") Integer idAlquiler){
        if (!alquilerService.findById(idAlquiler).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        alquilerService.deleteById(idAlquiler);
        return ResponseEntity.ok().build();
    }
}
