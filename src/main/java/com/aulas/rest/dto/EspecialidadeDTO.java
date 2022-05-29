package com.aulas.rest.dto;

import com.aulas.rest.entidades.Especialidade;

public class EspecialidadeDTO {
	private String especialidade;
	
	
	 public EspecialidadeDTO(Especialidade especialidade) {
	    	this.especialidade = especialidade.getEspecialidade();
		}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public EspecialidadeDTO(String especialidade) {
		this.especialidade = especialidade;
	}
	
	

}
