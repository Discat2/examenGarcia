package ec.edu.espe.examen.garcia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.garcia.dao.EspecialidadRepository;
import ec.edu.espe.examen.garcia.domain.Docente;
import ec.edu.espe.examen.garcia.domain.Especialidad;
import ec.edu.espe.examen.garcia.service.exceptions.CreateException;

@Service
public class DocenteService {
    private final DocenteService docenteService;

    public DocenteService(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    public Docente create(Docente docente) {
        try {
            return this.docenteService.save(docente);
        } catch (Exception e) {
            throw new CreateException(
                    "Ocurrio un error al crear la especialidad: " + docente.toString(), e);
        }
    }
}
