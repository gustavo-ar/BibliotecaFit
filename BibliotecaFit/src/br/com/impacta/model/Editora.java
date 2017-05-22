package br.com.impacta.model;

import java.util.HashMap;

public class Editora {
	
	private long idEditora;
	private String nomeEditora;
	
	private HashMap <String,String> parametros = new HashMap<String,String>();

	public long getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(long idEditora) {
		this.idEditora = idEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	
}
