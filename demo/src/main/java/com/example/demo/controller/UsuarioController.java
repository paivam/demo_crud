package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.service.UsuarioService;

@Controller
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuServ;

	@PostMapping("/cadastrarUsuario")
	public ResponseEntity<?> criarUsuario(@RequestBody Usuario uso, HttpServletRequest request) {
		return usuServ.cadastrarUsuario(uso, request);
	}

	@GetMapping("/listarUsuario")
	public ResponseEntity<?> buscarUsuario() {
         return usuServ.listarUsuario();
	}
	
	@PutMapping("/atualizarUsuario/{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usu, HttpServletRequest request) {
		return usuServ.atualizarUsuario(id, usu, request);
	}
}
