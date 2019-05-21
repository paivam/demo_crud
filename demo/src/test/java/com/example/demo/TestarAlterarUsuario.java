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
public class TestarAlterarUsuario {
	@Autowired
	private UsuarioRepository usoRepo;

	@Test
	public void AlterarUsuario() {
		Usuario uso = new Usuario();
		uso.setId(1);
		Usuario usu = usoRepo.findById(uso.getId()).orElse(null);

		if (usu == null) {
			System.out.println("Usuario não cadastrado");		
		}else
		usu.setCPF("466.266.228-11");  
		usu.setEmail("");
		usu.setNome("Matheus");
		usu.setTelefone("11952105262");

		usoRepo.save(usu);
		System.out.println(usu);

	}
}