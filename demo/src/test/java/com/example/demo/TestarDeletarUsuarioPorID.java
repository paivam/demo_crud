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
public class TestarDeletarUsuarioPorID {
	@Autowired
	private UsuarioRepository usoRepo;
	
	@Test
	public void deletarUsuarioPorID() {
		Usuario uso = new Usuario();
		uso.setId(99);
		usoRepo.deleteById(uso.getId());
		System.out.println("\n usuario de id" + " " + uso.getId() + " "+ "foi deletado \n");
	}
}
