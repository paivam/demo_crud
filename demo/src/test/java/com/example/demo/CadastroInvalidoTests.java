package com.example.demo;
 
import javax.validation.ConstraintViolationException;


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
public class CadastroInvalidoTests {
	@Autowired
	private UsuarioRepository usoRepo;
	@Autowired
	private UsuarioController usuCon;
	
	@Before
	public void setUp() throws Exception {

		usoRepo.deleteAll();
		
	}

	@Test(expected = ConstraintViolationException.class)
	public void cadastrarUsuario(){
		Usuario uso = new Usuario();
		uso.setCPF("46626622811");
		uso.setEmail("matheus.paiva@hotmail.com");
		uso.setTelefone("1195210262");
		uso.setNome("");
		usuCon.criarUsuario(uso);

}
}
