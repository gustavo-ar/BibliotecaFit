package br.com.impacta.model;

import java.util.Calendar;

public class Pessoa {

	private long idPessoa;
	private long idTipoPessoa;
	private String nome;
	private String email;
	private String telefone;
	private Calendar dataRegisto;
	private String cpf;
	private String senha;
	private Boolean inadmin;

	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public long getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(long idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(Calendar dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isInadmin() {
		return inadmin;
	}

	public void setInadmin(Boolean inadmin) {
		this.inadmin = inadmin;
	}

}
