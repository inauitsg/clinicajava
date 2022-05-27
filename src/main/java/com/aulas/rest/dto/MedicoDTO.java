package com.aulas.rest.dto;

import com.aulas.rest.entidades.Medico;

public class MedicoDTO {
	//private String especialidade;
    private String nome;
    private String crm;
    private String telefone;
    private String dias;
    
    public MedicoDTO(Medico medico) {
    	//this.especialidade = medico.getEspecialidade();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.telefone = medico.getTelefone();
		this.dias = medico.getDias();

	}
    
	
	public MedicoDTO(String especialidade, String nome, String crm, String telefone, String dias) {
		//this.especialidade = especialidade;
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.dias = dias;
	}
	/*public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}*/
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
    
    

}
