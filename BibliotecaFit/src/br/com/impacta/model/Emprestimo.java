package br.com.impacta.model;

import java.util.Calendar;

public class Emprestimo {

	private long idTipoPessoa;
	private long idPessoa;
	private long numExemplar;
	private Calendar dataEmprestimo;
	private Calendar dataPrevistaRetorno;
	public long getIdTipoPessoa() {
		return idTipoPessoa;
	}
	public void setIdTipoPessoa(long idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public long getNumExemplar() {
		return numExemplar;
	}
	public void setNumExemplar(long numExemplar) {
		this.numExemplar = numExemplar;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataPrevistaRetorno() {
		return dataPrevistaRetorno;
	}
	public void setDataPrevistaRetorno(Calendar dataPrevistaRetorno) {
		this.dataPrevistaRetorno = dataPrevistaRetorno;
	}

}
