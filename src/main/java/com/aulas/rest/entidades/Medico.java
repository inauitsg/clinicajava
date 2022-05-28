package com.aulas.rest.entidades;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
    private String crm;
    private String telefone;
    private String dias;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;

	public Instant getCreatedAt() {
		return createdAt;
	}
	public Instant getUpdateAt() {
		return updateAt;
	}
	@PrePersist
	public void prePersit() {
		createdAt = Instant.now();
	}
	@PreUpdate
	public void preUpdate() {
		updateAt = Instant.now();
	}
    
    @ManyToOne
    private Especialidade especialidade;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public Medico(int id, String nome, String crm, String telefone, String dias) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.dias = dias;
	}
	public Medico() {

	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
  
	
	
}
