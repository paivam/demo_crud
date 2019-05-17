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
		  uso.setCPF("4544545");
		  uso.setEmail("matahues@gmialo.vom");
		  uso.setTelefone(95210262);
		  uso.setNome("Fernan");
		  
		  usorepo.save(uso);
		  System.out.println(uso.getId());
	}
	
}
