package br.com.impacta.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Obra {

	private long idObra;
	private long idEditora;
	private String titulo;
	private Calendar anoPublicacao;
	private String tipoObra;

	private ArrayList<Exemplar> exemplares = new ArrayList<>();

	public long getIdObra() {
		return idObra;
	}

	public void setIdObra(long idObra) {
		this.idObra = idObra;
	}

	public long getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(long idEditora) {
		this.idEditora = idEditora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Calendar anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getTipoObra() {
		return tipoObra;
	}

	public void setTipoObra(String tipoObra) {
		this.tipoObra = tipoObra;
	}

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public void addExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);
	}

}
