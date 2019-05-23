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
@SpringBootTest 
public class BuscarNomeInvalidosTests {
	@Autowired
	private UsuarioRepository usuRepo;
	
	@Autowired
    private UsuarioController usuContro;

	@Before
	public void setUp() throws Exception {
		usuRepo.deleteAll();
		usuRepo.save(new Usuario("Juliana", "juliana@gamil.com","41232098825","1143424567"));
	    
	}
	@Test
	public void buscarTodosUsuario() {
		List<Usuario> list = usuRepo.findAll();
		Usuario uso = list.get(0);
		uso.setNome("Matheus");;
		usuContro.buscarUsuarioNome(uso.getNome());
	}
}
