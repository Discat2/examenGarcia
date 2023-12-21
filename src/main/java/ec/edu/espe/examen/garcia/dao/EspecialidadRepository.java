package ec.edu.espe.examen.garcia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examen.garcia.domain.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, String>{

    List<Especialidad> findByNombreLike(String patronNombre);
}