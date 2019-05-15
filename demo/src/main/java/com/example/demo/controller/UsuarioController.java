package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.service.UsuarioService;

@Controller("/api/")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuServ;
	
	@RequestMapping(value = "/cadastrarusuarios", method = RequestMethod.POST)
	public ResponseEntity<?> criarUsuario(@RequestBody Usuario uso, UriComponentsBuilder ucBuilder) {
		       return usuServ.cadastrarUsuario(uso);
		}
	}

