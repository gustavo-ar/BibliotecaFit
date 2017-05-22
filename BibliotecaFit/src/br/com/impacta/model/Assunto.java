package br.com.impacta.model;

import java.util.ArrayList;

public class Assunto {

	private long idAssunto;
	private String nomeAssunto;

	private ArrayList<Obra> obras = new ArrayList<>();

	public long getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(long idAssunto) {
		this.idAssunto = idAssunto;
	}

	public String getNomeAssunto() {
		return nomeAssunto;
	}

	public void setNomeAssunto(String nomeAssunto) {
		this.nomeAssunto = nomeAssunto;
	}

	public ArrayList<Obra> getObras() {
		return obras;
	}

	public void addObra(Obra obra) {
		this.obras.add(obra);
	}

}
