package com.example.demo;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.bean.Usuario;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CadastroInvalidoTests {
	@Autowired
	private UsuarioRepository usoRepo;
	@Autowired
    private UsuarioService usuServ;
	@Before
	public void setUp() throws Exception {

		usoRepo.deleteAll();

	}

	@Test(expected = ConstraintViolationException.class)
	public void cadastrarUsuario() {
		Usuario uso = new Usuario();
		uso.setCPF("");
		uso.setEmail("matheus.paiva@hotmail.com");
		uso.setTelefone("1195210262");
		uso.setNome("Matheus");
		usuServ.cadastrarUsuario(uso);
	}
}
