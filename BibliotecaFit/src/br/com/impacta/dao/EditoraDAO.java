package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.impacta.model.Editora;
import br.com.impacta.sql.ConnectionFactory;

public class EditoraDAO {

	private Connection connection;

	public EditoraDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Editora editora) {

		String sql = "insert into tb_editoras" + "(idEditora,nomeEditora)" + "values (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, editora.getIdEditora());
			stmt.setString(2, editora.getNomeEditora());

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void altera(Editora editora) {

		String sql = "update tb_editoras set nomeEditora=? where idEditora=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, editora.getNomeEditora());

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void remove(Editora editora) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_editoras where idEditora=?");

			stmt.setLong(1, editora.getIdEditora());

			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public ArrayList<Editora> getEditoras() {

		try {
			ArrayList<Editora> editoras = new ArrayList<Editora>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_editoras");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Editora
				Editora editora = new Editora();
				editora.setIdEditora(rs.getLong("idEditora"));
				editora.setNomeEditora(rs.getString("nomeAutor"));

				// adicionando o objeto à lista
				editoras.add(editora);

			}
			rs.close();
			stmt.close();
			return editoras;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
