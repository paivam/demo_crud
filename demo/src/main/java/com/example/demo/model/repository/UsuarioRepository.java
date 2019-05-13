package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.bean.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
}
