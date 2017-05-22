package br.com.impacta.model;

import java.util.Calendar;

public class Reserva {

	private long idReserva;
	private long idPessoa;
	private long idTipoPessoa;
	private Calendar dataReserva;
	private Calendar dataRetirada;

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

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

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Calendar getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Calendar dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

}
