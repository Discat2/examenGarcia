package ec.edu.espe.examen.garcia.service;
import org.springframework.stereotype.Service;
import java.util.List;

import ec.edu.espe.examen.garcia.dao.EspecialidadRepository;
import ec.edu.espe.examen.garcia.domain.Especialidad;
import ec.edu.espe.examen.garcia.service.exceptions.CreateException;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public Especialidad create(Especialidad especialidad) {
        try {
            return this.especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new CreateException(
                    "Ocurrio un error al crear la especialidad: " + especialidad.toString(), e);
        }
    }
    public List<Especialidad> getByNombre(String Nombre) {
        return this.especialidadRepository.findByNombreLike(Nombre);
    }
}
