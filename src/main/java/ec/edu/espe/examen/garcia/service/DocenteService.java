package ec.edu.espe.examen.garcia.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.garcia.dao.DocenteRepository;
import ec.edu.espe.examen.garcia.domain.Docente;
import ec.edu.espe.examen.garcia.service.exceptions.CreateException;

@Service
public class DocenteService {
    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public Docente create(Docente docente) {
        try {
            return this.docenteRepository.save(docente);
        } catch (Exception e) {
            throw new CreateException(
                    "Ocurrio un error al crear el docente: " + docente.toString(), e);
        }
    }
}
