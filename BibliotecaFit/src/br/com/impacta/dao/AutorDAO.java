package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.impacta.model.Autor;
import br.com.impacta.sql.ConnectionFactory;

public class AutorDAO {

	private Connection connection;

	public AutorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Autor autor) {

		String sql = "insert into tb_autores" + "(idAutor,nomeAutor)" + "values (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, autor.getIdAutor());
			stmt.setString(2, autor.getNomeAutor());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Autor autor) {

		String sql = "update tb_autores set nomeAutor=? where idAutor=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, autor.getNomeAutor());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Autor autor) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_autores where idAutor=?");
			
			stmt.setLong(1, autor.getIdAutor());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Autor> getAutores() {
		try {
			ArrayList<Autor> autores = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_autores");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Autor
				Autor autor = new Autor();
				autor.setIdAutor(rs.getLong("idAutor"));
				autor.setNomeAutor(rs.getString("nomeAutor"));

				// adicionando o objeto à lista
				autores.add(autor);
			}
			rs.close();
			stmt.close();
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
