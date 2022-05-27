package com.aulas.rest.controles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.rest.entidades.Medico;
import com.aulas.rest.repositorios.MedicoRepositorio;

@RestController
@RequestMapping("/")
public class MedicoController {
	@Autowired
	MedicoRepositorio repositoryMedico;
	
	@GetMapping
	public String index(){
		return "index";
	}
	
	@GetMapping("/cadastromedicos")
	public String formMedico(Model model) {
		model.addAttribute("medico", new Medico());
		return "cadastromedicos";
	}
	
	@PostMapping("/editarmedicos")
	public String alterar(@ModelAttribute Medico medico) {
		repositoryMedico.save(medico);
		return "redirect:/consultamedicos";
	}
	
	@PostMapping("/cadastromedicos")
	public String inserir(@ModelAttribute Medico medico) {
		repositoryMedico.save(medico);
		return "redirect:/consultamedicos";
	}
	
	@GetMapping("/consultamedicos")
	public String consulta(Model model) {
		Iterable<Medico> lista = repositoryMedico.findAll();
		model.addAttribute("medico", lista);
		return "consultamedicos";
	}
	
	@GetMapping("/consultamedicos/{idmedico}")
	public String formEditar(@PathVariable("idmedico") int id, Model model) {
		Optional<Medico> ct = repositoryMedico.findById(id);
		model.addAttribute("medico", ct);
		return "editamedicos";
	}
	
	@GetMapping("/excluir/{idmedico}")
	public String excluirMedico(@PathVariable("idmedico") int idmedico, Model model) {
		repositoryMedico.deleteById(idmedico);
		return "redirect:/consultamedicos";
	}
	
	/*
	@GetMapping("/medico")
	public ResponseEntity<List<MedicoDTO>> pegaUsuarios() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@GetMapping("/{idmedico}")
	public ResponseEntity<MedicoDTO> pegarMedico(@PathVariable("idmedico") int idmedico) {
		MedicoDTO medicosDTO = service.pegarMedico(idmedico);
		return ResponseEntity.status(HttpStatus.OK).body(medicosDTO);
	}

	@PostMapping
	public ResponseEntity<MedicoDTO> salvar(@RequestBody Medico medico) {
		MedicoDTO med = service.salvar(medico);
		return ResponseEntity.status(HttpStatus.CREATED).body(med);
	}

	@PutMapping("/{idmedico}")
	public ResponseEntity<MedicoDTO> alterar(@PathVariable("idmedico") int idmedico, @RequestBody Medico medico) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idmedico, medico));
	}

	@DeleteMapping("/{idmedico}")
	public ResponseEntity<MedicoDTO> excluir(@PathVariable("idmedico") int idmedico) {
		try {
			service.excluir(idmedico);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}*/

}
