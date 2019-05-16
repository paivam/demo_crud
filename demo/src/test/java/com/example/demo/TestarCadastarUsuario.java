package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestarCadastarUsuario {
	@Autowired
	private UsuarioRepository usorepo;
	
	@Test
	public void cadastrarUsuario() {
		Usuario uso = new Usuario();
		  uso.setCPF("18759687459");
		  uso.setEmail("fernanda@gamil.com");
		  uso.setTelefone(985868523);
		  uso.setNome("Fernanda");
		  
		  usorepo.save(uso);
		  System.out.println(uso.getId());
	}
	
}
