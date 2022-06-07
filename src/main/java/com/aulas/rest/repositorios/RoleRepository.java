package com.aulas.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entidades.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	

}
