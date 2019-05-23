package com.example.demo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.UsuarioController;
import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DeletarInvalidoTests {
	@Autowired
	private UsuarioRepository usoRepo;
	@Autowired
    private UsuarioController usuContro;
	@Before
	public void setUp() throws Exception {
		usoRepo.deleteAll();
		usoRepo.save(new Usuario("Matheus", "matheus@gmail.com","46626622811","1122532173"));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void deletarUsuarioPorID() {
		List<Usuario> list = usoRepo.findAll();
		Usuario usu = list.get(0);
		usu.setId(90);
		usuContro.deletarUsuario(usu.getId());
	}
}