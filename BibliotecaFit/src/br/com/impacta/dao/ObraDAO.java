package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

			stmt.setLong(1, obra.getIdObra());
			stmt.setLong(2, obra.getIdEditora());
			stmt.setString(3, obra.getTitulo());
			// stmt.setDate(4, obra.getAnoPublicacao()); //VERIFICAR O CAST E RETORNO
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

			stmt.setLong(1, obra.getIdEditora());
			stmt.setString(2, obra.getTitulo());
			// stmt.setDate(3, obra.getAnoPublicacao()); //VERIFICAR O CAST E RETORNO
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

}
