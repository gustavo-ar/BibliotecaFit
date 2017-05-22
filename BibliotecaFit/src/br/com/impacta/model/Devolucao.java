package br.com.impacta.model;

import java.util.Calendar;

public class Devolucao {

	private long idDevolucao;
	private long idEmprestimo;
	private Calendar dataDevolucao;

	public long getIdDevolucao() {
		return idDevolucao;
	}

	public void setIdDevolucao(long idDevolucao) {
		this.idDevolucao = idDevolucao;
	}

	public long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}
