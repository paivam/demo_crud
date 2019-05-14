package com.example.demo.model.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

public class UsuarioService {
	
      @Autowired
      private UsuarioRepository usuRepo;
      
      public ResponseEntity<?> cadastrarUsuario(Usuario uso, HttpServletRequest request) {
  	    try { 
  	    	 
  	    	 usuRepo.save(uso);
  	  
  		}catch(Exception e){
  			e.printStackTrace();
  			return ResponseEntity.badRequest().body("Não foi possivel realizar o cadastro");
  		}
  	       return ResponseEntity.ok("Cadastro realizado com sucesso");
     }
}