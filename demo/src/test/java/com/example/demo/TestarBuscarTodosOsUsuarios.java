package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class TestarBuscarTodosOsUsuarios {
	@Autowired
	private UsuarioRepository usuRepo;
		@Test
		public void buscartodosusuario() {
			List<Usuario> list = usuRepo.findAll();
			System.out.println(" \n vou imprimir todos os usuarios do banco agora \n");
			System.out.println(list);
	}
}
