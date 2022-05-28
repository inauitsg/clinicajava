package com.aulas.rest.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.rest.dto.MedicoDTO;
import com.aulas.rest.entidades.Medico;
import com.aulas.rest.repositorios.MedicoRepositorio;
import com.aulas.rest.servicos.excecoes.RecursoNaoEncontrado;

@Service
public class MedicoService {

	@Autowired	
	   MedicoRepositorio repo;
	
	public List<MedicoDTO> listarTodos(){
		List<Medico> medicos = repo.findAll();
		
		List<MedicoDTO> medicosDTO = new ArrayList<>();		
		
		for(Medico med : medicos) {
			medicosDTO.add(new MedicoDTO(med));
		}		
		return medicosDTO;
	}
	
	public MedicoDTO salvar(Medico medico) {
		Medico med = repo.save(medico);
		return new MedicoDTO(med);
	}
	
	public MedicoDTO pegarMedico(int idmedico) {
	  Optional<Medico> obj = repo.findById(idmedico);	
	  Medico med = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado."));
	  return new MedicoDTO(med);
	}
	
	public MedicoDTO alterar(int idmedico, Medico medico) {
		Optional<Medico > obj = repo.findById(idmedico);
		Medico med = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado."));
	
		med.setEspecialidade(medico.getEspecialidade());
		med.setNome(medico.getNome());
		med.setCrm(medico.getCrm());
		med.setTelefone(medico.getTelefone());
		med.setDias(medico.getDias());
		med = repo.save(med);
		return new MedicoDTO(med);
	}
	
	public void excluir(int idmedico) {
		repo.deleteById(idmedico);
	}
}
