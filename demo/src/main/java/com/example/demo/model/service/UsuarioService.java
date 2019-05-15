package com.example.demo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
      @Autowired
      private UsuarioRepository usuRepo;
      
      public ResponseEntity<Usuario> cadastrarUsuario(Usuario uso) {
  	    try { 
  	    	 
  	    	 usuRepo.save(uso);
  	    	 return new ResponseEntity<Usuario>(uso, HttpStatus.OK); 
  	    	 
  	    }catch(Exception e){
  			e.printStackTrace();
  			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
     }
}