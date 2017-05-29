package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.impacta.model.Reserva;
import br.com.impacta.sql.ConnectionFactory;

public class ReservaDAO {
	
	private Connection connection;

	public ReservaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Reserva reserva) {

		String sql = "INSERT INTO tb_reservas (idReserva,dataReserva,dataRetirada) VALUES (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, reserva.getIdReserva());
			stmt.setDate(2, (java.sql.Date) new Date(reserva.getDataReserva().getTimeInMillis()));
			stmt.setDate(3, (java.sql.Date) new Date(reserva.getDataRetirada().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void altera(Reserva reserva) {

		String sql = "UPDATE tb_reservas set dataReserva=?, dataPrevistaRetirada=? where idReserva=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setDate(2, (java.sql.Date) new Date(reserva.getDataReserva().getTimeInMillis()));
			stmt.setDate(3, (java.sql.Date) new Date(reserva.getDataRetirada().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void remove(Reserva reserva) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_reservas where idReserva=?");

			stmt.setLong(1, reserva.getIdReserva());

			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public ArrayList<Reserva> getReservas() {

		try {
			ArrayList<Reserva> reservas = new ArrayList<Reserva>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_reservas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Reserva
				Reserva reserva = new Reserva();

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataReserva"));
				reserva.setDataReserva(data);

				// montando a data através do Calendar
				Calendar dataR = Calendar.getInstance();
				dataR.setTime(rs.getDate("dataRetirada"));
				reserva.setDataRetirada(dataR);
				
				// adicionando o objeto à lista
				reservas.add(reserva);

			}
			rs.close();
			stmt.close();
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
