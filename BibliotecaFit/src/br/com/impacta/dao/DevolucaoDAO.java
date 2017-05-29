package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.impacta.model.Devolucao;
import br.com.impacta.sql.ConnectionFactory;

public class DevolucaoDAO {
	
	private Connection connection;

	public DevolucaoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Devolucao devolucao) {

		String sql = "INSERT INTO tb_devolucoes (idDevolucao,dataDevolucao) VALUES (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, devolucao.getIdDevolucao());
			stmt.setDate(2, (java.sql.Date) new Date(devolucao.getDataDevolucao().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void altera(Devolucao devolucao) {

		String sql = "UPDATE tb_devolucoes set dataDevolucao=? where idDevolucao=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setDate(1, (java.sql.Date) new Date(devolucao.getDataDevolucao().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void remove(Devolucao devolucao) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_devolucoes where idDevolucao=?");

			stmt.setLong(1, devolucao.getIdDevolucao());

			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public ArrayList<Devolucao> getDevolucoes() {

		try {
			ArrayList<Devolucao> devolucoes = new ArrayList<Devolucao>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_emprestimos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Editora
				Devolucao devolucao = new Devolucao();
				devolucao.setIdDevolucao(rs.getLong("idDevolucao"));

				// montando a data de emprestimo através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataDevolucao"));
				devolucao.setDataDevolucao(data);

				// adicionando o objeto à lista
				devolucoes.add(devolucao);

			}
			rs.close();
			stmt.close();
			return devolucoes;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
