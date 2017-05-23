package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.impacta.model.Assunto;
import br.com.impacta.sql.ConnectionFactory;

public class AssuntoDAO {
	
	private Connection connection;

	public AssuntoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Assunto assunto) {

		String sql = "insert into tb_assuntos" + "(idAssunto,nomeAssunto)" + "values (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, assunto.getIdAssunto());
			stmt.setString(2, assunto.getNomeAssunto());

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void altera(Assunto assunto) {

		String sql = "update tb_assuntos set nomeAssunto=? where idAssunto=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, assunto.getNomeAssunto());

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void remove(Assunto assunto) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_assuntos where idAssunto=?");

			stmt.setLong(1, assunto.getIdAssunto());

			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public ArrayList<Assunto> getAssuntos() {

		try {
			ArrayList<Assunto> assuntos = new ArrayList<Assunto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_assuntos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Assunto
				Assunto assunto = new Assunto();
				assunto.setIdAssunto(rs.getLong("idAssunto"));
				assunto.setNomeAssunto(rs.getString("nomeAssunto"));
				
				// adicionando o objeto à lista
				assuntos.add(assunto);

			}
			rs.close();
			stmt.close();
			return assuntos;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
