package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.service.UsuarioService;

@Controller("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuServ;

	@PostMapping
	public ResponseEntity<?> criarUsuario(@RequestBody Usuario uso, HttpServletRequest request) {
		return usuServ.cadastrarUsuario(uso, request);
	}

	@GetMapping
	public ResponseEntity<?> buscarUsuario() {
         return usuServ.listarUsuario();
	}
}
