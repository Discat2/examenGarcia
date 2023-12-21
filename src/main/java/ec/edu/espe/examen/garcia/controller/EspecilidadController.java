package ec.edu.espe.examen.garcia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.garcia.domain.Especialidad;
import ec.edu.espe.examen.garcia.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecilidadController {
    @Autowired
    private EspecialidadService especialidadService;

    
    @PostMapping("/save")
    public ResponseEntity<Especialidad> Save(@RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(especialidadService.create(especialidad), HttpStatus.OK);
    }
}
