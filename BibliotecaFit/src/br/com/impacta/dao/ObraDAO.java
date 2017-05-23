package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.impacta.model.Obra;
import br.com.impacta.sql.ConnectionFactory;

public class ObraDAO {

	private Connection connection;

	public ObraDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Obra obra) {

		String sql = "insert into tb_obras" + "(idObra,idEditora,titulo,anoPublicacao,tipoObra)" + "values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, obra.getIdObra());
			stmt.setLong(2, obra.getIdEditora());
			stmt.setString(3, obra.getTitulo());
			stmt.setDate(4, (java.sql.Date) new Date(obra.getAnoPublicacao().getTimeInMillis()));
			stmt.setString(5, obra.getTipoObra());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Obra obra) {

		String sql = "update tb_obras set idEditora=?, titulo=?," + "anoPublicacao=?, tipoObra=? where idObra=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, obra.getIdEditora());
			stmt.setString(2, obra.getTitulo());
			stmt.setDate(3, (java.sql.Date) new Date(obra.getAnoPublicacao().getTimeInMillis()));
			stmt.setString(4, obra.getTipoObra());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Obra obra) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_obras where idObra=?");
			stmt.setLong(1, obra.getIdObra());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Obra> getObras() {

		try {
			ArrayList<Obra> obras = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_obras");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Obra
				Obra obra = new Obra();
				obra.setIdObra(rs.getLong("idObra"));
				obra.setIdEditora(rs.getLong("idEditora"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setTipoObra(rs.getString("tipoObra"));

				// pegando o ano através do Calendar
				Calendar c = Calendar.getInstance();
				c.get(Calendar.YEAR);
				c.setTime(rs.getDate("anoPublicacao"));
				obra.setAnoPublicacao(c);

				// adicionando o objeto à lista
				obras.add(obra);
			}
			rs.close();
			stmt.close();
			return obras;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
