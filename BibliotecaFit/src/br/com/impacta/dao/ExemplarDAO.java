package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.impacta.model.Exemplar;
import br.com.impacta.sql.ConnectionFactory;

public class ExemplarDAO {

	private Connection connection;

	public ExemplarDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Exemplar exemplar) {

		String sql = "INSERT INTO tb_exemplares (numExemplar,situacaoExemplar,dataAquisicao) VALUES (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, exemplar.getNumExemplar());
			stmt.setBoolean(2, exemplar.getSituacaoExemplar());
			stmt.setDate(3, (java.sql.Date) new Date(exemplar.getDataAquisicao().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void altera(Exemplar exemplar) {

		String sql = "UPDATE tb_exemplares set situacaoExemplar=?,dataAquisicao=? where numExemplar=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setBoolean(1, exemplar.getSituacaoExemplar());
			stmt.setDate(2, (java.sql.Date) new Date(exemplar.getDataAquisicao().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void remove(Exemplar exemplar) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_exemplares where numExemplar=?");

			stmt.setLong(1, exemplar.getNumExemplar());

			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public ArrayList<Exemplar> getExemplares() {

		try {
			ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_emprestimos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Editora
				Exemplar exemplar = new Exemplar();
				exemplar.setNumExemplar(rs.getLong("numExemplar"));
				exemplar.setSituacaoExemplar(rs.getBoolean("situacaoExemplar"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				exemplar.setDataAquisicao(data);

				// adicionando o objeto à lista
				exemplares.add(exemplar);

			}
			rs.close();
			stmt.close();
			return exemplares;

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
