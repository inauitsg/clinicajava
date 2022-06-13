package com.aulas.rest.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entidades.Usuario;
import com.aulas.rest.repositorios.UsuarioRepositorio;
import com.aulas.rest.servicos.excecoes.RecursoNaoEncontrado;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired	
	private UsuarioRepositorio repo;

	public List<UsuarioDTO> listarTodos(){
		List<Usuario> usuarios = repo.findAll();

		List<UsuarioDTO> usuariosDTO = new ArrayList<>();		

		for(Usuario user : usuarios) {
			usuariosDTO.add(new UsuarioDTO(user));
		}		
		return usuariosDTO;
	}
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	

	public UsuarioDTO salvar(UsuarioDTO usuario) {
		
		try {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		Usuario user = repo.save(new Usuario(usuario));
	
		return new UsuarioDTO(user);
	}
		catch(Exception e) {
			
			throw new DataIntegrityViolationException("Email já cadastrado");
		}
	}

	public UsuarioDTO pegarUsuario(Long idusuario) {
		Optional<Usuario> obj = repo.findById(idusuario);	
		Usuario user = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado."));
		return new UsuarioDTO(user);
	}

	public UsuarioDTO alterar(Long idusuario, UsuarioDTO usuario) {
		Optional<Usuario> obj = repo.findById(idusuario);
		Usuario user = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado."));

		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		user.setSenha(usuario.getSenha());
		user = repo.save(user);
		return new UsuarioDTO(user);
	}

	public void excluir(Long idusuario) {
		repo.deleteById(idusuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}
	
}