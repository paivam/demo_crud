package com.example.demo.model.service;

import java.net.URI;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.bean.DetalhesRetorno;
import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuRepo;

	@Autowired
	private DetalhesRetorno retorno;

	public ResponseEntity<?> cadastrarUsuario(Usuario uso, HttpServletRequest request) {

		Usuario t = usuRepo.save(uso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(t.getId()).toUri();

		return ResponseEntity.created(uri)
				.body(this.retorno.build(new Date(), "Cadastro realizado", "uri=" + request.getRequestURI()));

	}

	public ResponseEntity<?> listarUsuario() {
		return ResponseEntity.ok().header("Content-Type", MediaType.APPLICATION_JSON.toString()).body(usuRepo.findAll());
	}
	
	public ResponseEntity<?> atualizarUsuario(Long id, Usuario usu, HttpServletRequest request) {
		Usuario usuario = usuRepo.findById(id).get();
		usuario.setNome(usu.getNome());
		usuario.setCPF(usu.getCPF());
		usuario.setEmail(usu.getEmail());
		usuario.setTelefone(usu.getTelefone());
		usuRepo.save(usuario);
		return ResponseEntity.ok(this.retorno.build(new Date(), "Cadastro realizado", "uri=" + request.getRequestURI()));
	}

}