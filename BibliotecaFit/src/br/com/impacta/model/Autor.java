package br.com.impacta.model;

import java.util.ArrayList;

public class Autor {
	
	private long idAutor;
	private String nomeAutor;
	private ArrayList<Obra> obras = new ArrayList<>();
	
	public long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public ArrayList<Obra> getObras() {
		return obras;
	}
	
	public void addObra(Obra obra) {
		this.obras.add(obra);
	}
	

}
