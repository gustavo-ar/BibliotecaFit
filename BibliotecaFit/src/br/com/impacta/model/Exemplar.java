package br.com.impacta.model;

import java.util.Calendar;

public class Exemplar {

	private long numExemplar;
	private long idObra;
	private Boolean situacaoExemplar;
	private Calendar dataAquisicao;

	public long getNumExemplar() {
		return numExemplar;
	}

	public void setNumExemplar(long numExemplar) {
		this.numExemplar = numExemplar;
	}

	public long getIdObra() {
		return idObra;
	}

	public void setIdObra(long idObra) {
		this.idObra = idObra;
	}

	public Boolean getSituacaoExemplar() {
		return situacaoExemplar;
	}

	public void setSituacaoExemplar(Boolean situacaoExemplar) {
		this.situacaoExemplar = situacaoExemplar;
	}

	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

}
