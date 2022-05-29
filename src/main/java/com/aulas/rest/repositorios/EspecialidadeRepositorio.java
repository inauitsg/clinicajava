package com.aulas.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entidades.Especialidade;

@Repository
public interface EspecialidadeRepositorio extends JpaRepository<Especialidade, Integer>{

}
