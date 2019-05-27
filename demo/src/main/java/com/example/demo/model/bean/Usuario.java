package com.example.demo.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String nome;
	@NotNull
	@Column(unique = true)
	@Email
	private String email;
	@NotNull
	@Column(unique = true)
	@CPF
	private String cpf;
	@NotNull
	private String telefone;

	public Usuario() {
		super();
		
	}

	public Usuario(@NotNull String nome, @NotNull @Email String email, @NotNull @CPF String cpf,
			@NotNull String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.equals("")) {
			nome = null;
		}
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.equals("")) {
			email = null;
		}
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCPF(String cpf) {
		if (cpf.equals("")) {
			cpf = null;
		}
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone.equals("")) {
			telefone = null;
		}
		this.telefone = telefone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", CPF=" + cpf + ", telefone=" + telefone
				+ "]";
	}

}
