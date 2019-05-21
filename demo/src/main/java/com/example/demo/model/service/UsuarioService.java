package com.example.demo.model.service;

import java.net.URI;
import java.util.Date;
import java.util.List;

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
		try {
			Usuario t = usuRepo.save(uso);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(t.getId())
					.toUri();
			return ResponseEntity.created(uri)
					.body(this.retorno.build(new Date(), "Cadastro realizado", "uri=" + request.getRequestURI()));
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(this.retorno.build(new Date(), "usuario já cadastrado", "uri=" + request.getRequestURI()));
		}

	}

	public ResponseEntity<?> listarUsuario() {
		return ResponseEntity.ok().header("Content-Type", MediaType.APPLICATION_JSON.toString())
				.body(usuRepo.findAll());
	}

	public ResponseEntity<?> atualizarUsuario(Long id, Usuario usu, HttpServletRequest request) {
		try {
			Usuario usuario = usuRepo.findById(id).orElse(null);
			if (usu != null) {
				usuario.setNome(usu.getNome());
				usuario.setCPF(usu.getCpf());
				usuario.setEmail(usu.getEmail());
				usuario.setTelefone(usu.getTelefone());
				usuRepo.save(usuario);

				return ResponseEntity
						.ok(this.retorno.build(new Date(), "usuário atualizado", "uri=" + request.getRequestURI()));
			}
			return ResponseEntity.badRequest().body(
					this.retorno.build(new Date(), "Os campos não podem ser nulos", "uri=" + request.getRequestURI()));

		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(this.retorno.build(new Date(), "Usuário não encontrado", "uri=" + request.getRequestURI()));
		}

	}

	public ResponseEntity<?> deletarUsuario(Long id, HttpServletRequest request) {
		try {
			usuRepo.delete(usuRepo.findById(id).get());

		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(this.retorno.build(new Date(), "Usuário não cadastrado", "uri=" + request.getRequestURI()));
		}
		return ResponseEntity.ok(this.retorno.build(new Date(), "Usuário deletado", "uri=" + request.getRequestURI()));
	}

	public ResponseEntity<?> buscarUsuarioPorNome(String nome, HttpServletRequest request) {
		List<Usuario> usu = usuRepo.findAllByNomeIgnoreCase(nome);                     
		if (usu != null && !usu.isEmpty()) {
			return ResponseEntity.ok().header("Content-Type", MediaType.APPLICATION_JSON.toString()).body(usu);
		}
		return ResponseEntity.badRequest()
				.body(this.retorno.build(new Date(), "Usuário não cadastrado", "uri=" + request.getRequestURI()));
	}
}
