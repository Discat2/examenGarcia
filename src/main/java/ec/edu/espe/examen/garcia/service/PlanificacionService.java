package ec.edu.espe.examen.garcia.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.garcia.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.garcia.dao.DocenteRepository;
import ec.edu.espe.examen.garcia.dao.MateriaRepository;
import ec.edu.espe.examen.garcia.domain.Docente;
import ec.edu.espe.examen.garcia.domain.DocenteMateria;
import ec.edu.espe.examen.garcia.domain.DocenteMateriaPK;
import ec.edu.espe.examen.garcia.domain.Materia;
import ec.edu.espe.examen.garcia.service.exceptions.CreateException;

@Service
public class PlanificacionService {
    private final DocenteMateriaRepository docenteMateriaRepository;
    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;



    public PlanificacionService(DocenteMateriaRepository docenteMateriaRepository, DocenteRepository docenteRepository,
            MateriaRepository materiaRepository) {
        this.docenteMateriaRepository = docenteMateriaRepository;
        this.docenteRepository = docenteRepository;
        this.materiaRepository = materiaRepository;
    }


    public DocenteMateria AsignarMateriaDocente(Integer docenteID, Integer materiaID) {
        try {
            Optional<Docente> docente = docenteRepository.findById(docenteID);
            Optional<Materia> materia = materiaRepository.findById(materiaID);
            if(docente.isPresent() && materia.isPresent()){
                DocenteMateriaPK docenteMateriaPK = new DocenteMateriaPK(docente.get().getCodDocente(), materia.get().getCodMateria());
                DocenteMateria newDocenteMateria = new DocenteMateria(docenteMateriaPK);
                return docenteMateriaRepository.save(newDocenteMateria);
            }else{
                throw new RuntimeException(
                    "Error en la asignacion del docente y la materia " + docenteID + " - " + materiaID );
            }
        } catch (Exception e) {
            throw new CreateException(
                    "Ocurrio un error al crear la DocenteMateria: ", e);
        }
    }
}
