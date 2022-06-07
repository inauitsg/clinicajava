package com.aulas.rest.dto;

import java.io.Serializable;
import java.util.Set;

import com.aulas.rest.entidades.Role;
import com.aulas.rest.entidades.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Set<Role>roles;


	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String nome, String email, String perfil,
			String senha,Set<Role>roles) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.roles =roles;
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.roles =usuario.getRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}