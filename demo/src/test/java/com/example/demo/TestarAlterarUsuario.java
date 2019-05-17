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
		uso.setId(99);
		Usuario usu = usoRepo.findById(uso.getId()).orElse(null);

		if (usu == null) {
			System.out.println("Usuario não cadastrado");		
		}else
		usu.setCPF("59623215963");
		usu.setEmail("gabriel@amanha.com");
		usu.setNome("gabriel");
		usu.setTelefone(982391036);

		usoRepo.save(usu);
		System.out.println(usu);

	}
}