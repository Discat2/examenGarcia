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
import ec.edu.espe.examen.garcia.service.PlanificacionService;

@RestController
@RequestMapping("/planificacion")
public class PlanificacionServiceController {
    @Autowired
    private PlanificacionService planificacionService;

    
    @PostMapping("/asignar")
    public ResponseEntity<Especialidad> AsignarMateriaDocente(@RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(planificacionService.AsignarMateriaDocente(especialidad), HttpStatus.OK);
    }
}
