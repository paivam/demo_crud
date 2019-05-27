package com.example.demo;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.UsuarioController;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DeletarInvalidoTests {
	@Autowired
    private UsuarioController usuCon;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test(expected = NoSuchElementException.class)
	public void deletarUsuarioPorID() {
		usuCon.deletarUsuario(8L);
}
}