package com.aulas.rest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entidades.Medico;

@Repository
public interface MedicoRepositorio extends CrudRepository<Medico, Integer> {

}
