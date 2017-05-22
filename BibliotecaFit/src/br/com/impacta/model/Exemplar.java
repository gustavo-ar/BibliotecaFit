package br.com.impacta.model;

import java.util.Date;

public class Exemplar {

	private long numExemplar;
	private long idObra;
	private Boolean emprestado;
	private Date dataAquisicao;

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

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

}
