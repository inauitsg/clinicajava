package com.aulas.rest.entidades;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aulas.rest.dto.UsuarioDTO;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
    @Column(name="CREATED_AT", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(name="UPDATE_AT",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "tb_usuario_role",
			joinColumns = @JoinColumn(name= "usuario_id"),
			inverseJoinColumns =  @JoinColumn(name ="role_id")
			
			)
	private Set<Role> roles= new HashSet<>();
	

	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String senha,Set<Role> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.roles = roles;
	}
	
	public Usuario(UsuarioDTO usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.roles= usuario.getRoles();
	}
	
	@PrePersist
	public void prePersit() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateAt = Instant.now();
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}
	
	public Instant getUpdateAt() {
		return updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getAuthority()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		
		return this.senha;
	}

	@Override
	public String getUsername() {
		
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	
}