package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuRepo;

	public ResponseEntity<?> cadastrarUsuario(Usuario uso) {
		usuRepo.save(uso);
		return ResponseEntity.ok("Cadastro Realizado");
	}

	public ResponseEntity<?> listarUsuario() {
		return ResponseEntity.ok().header("Content-Type", MediaType.APPLICATION_JSON.toString())
				.body(usuRepo.findAll());
	}

	public ResponseEntity<?> atualizarUsuario(Long id, Usuario usu) {
		Usuario usuario = usuRepo.findById(id).orElse(null);

		if (usu != null) {

			usuario.setNome(usu.getNome());
			usuario.setCPF(usu.getCpf());
			usuario.setEmail(usu.getEmail());
			usuario.setTelefone(usu.getTelefone());
			usuRepo.save(usuario);
		}
		return ResponseEntity.ok("Usuario Atualizado");
	}

	public ResponseEntity<?> deletarUsuario(Long id) {
		usuRepo.delete(usuRepo.findById(id).get());

		return ResponseEntity.ok("Usuario deletado com sucesso");

	}

	public ResponseEntity<?> buscarUsuarioPorNome(String nome) {
		List<Usuario> usu = usuRepo.findAllByNomeIgnoreCase(nome);
		if (usu != null && !usu.isEmpty()) {
			return ResponseEntity.ok().header("Content-Type", MediaType.APPLICATION_JSON.toString()).body(usu);
		}
		return ResponseEntity.badRequest().body("Não encontramos Usuarios com esse nome");
	}
}
