package com.aulas.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entidades.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}
