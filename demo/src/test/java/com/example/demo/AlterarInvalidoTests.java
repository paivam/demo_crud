package com.example.demo;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import com.example.demo.controller.UsuarioController;
import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AlterarInvalidoTests {
	@Autowired
	private UsuarioRepository usoRepo;
	@Autowired
    private UsuarioController usuContro;
	
	@Before
	public void setUp() throws Exception {

		usoRepo.deleteAll();
		usoRepo.save(new Usuario("Juliana", "juliana@gamil.com","41232098825","1143424567"));
	}
	@Test(expected = TransactionSystemException.class)
	public void AlterarUsuario() {
		List<Usuario> list = usoRepo.findAll();
		Usuario usu = list.get(0);
		usu.setNome("");
		usuContro.atualizarUsuario(usu.getId(), usu);
		System.out.println(usu.toString());
		
	}
}