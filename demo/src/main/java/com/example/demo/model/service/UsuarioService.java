package com.example.demo.model.service;

import java.net.URI;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

public class UsuarioService {
	
      @Autowired
      private UsuarioRepository usuRepo;
      
      public ResponseEntity<Usuario> cadastrarUsuario(Usuario uso, HttpServletRequest request) {
  	    Usuario usuario = usuRepo.save(uso);
  	   
  	    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(usuario.getId()).toUri();

		return ResponseEntity.created(uri)(new Date(), "Cadastro realizado", "uri=" + request.getRequestURI()));

     }
}