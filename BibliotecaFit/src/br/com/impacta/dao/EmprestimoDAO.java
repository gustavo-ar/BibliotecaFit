package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.impacta.model.Emprestimo;
import br.com.impacta.sql.ConnectionFactory;

public class EmprestimoDAO {

	private Connection connection;

	public EmprestimoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Emprestimo emprestimo) {

		String sql = "INSERT INTO tb_emprestimos (idEmprestimo,numExemplar,dataEmprestimo,dataPrevistaRetorno) VALUES (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, emprestimo.getIdEmprestimo());
			stmt.setLong(2, emprestimo.getNumExemplar());
			stmt.setDate(3, (java.sql.Date) new Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			stmt.setDate(4, (java.sql.Date) new Date(emprestimo.getDataPrevistaRetorno().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void altera(Emprestimo emprestimo) {

		String sql = "UPDATE tb_emprestimos set numExemplar=?,dataEmprestimo=?, dataPrevistaRetorno=? where idEmprestimo=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, emprestimo.getNumExemplar());
			stmt.setDate(2, (java.sql.Date) new Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			stmt.setDate(3, (java.sql.Date) new Date(emprestimo.getDataPrevistaRetorno().getTimeInMillis()));

			// executa
			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void remove(Emprestimo emprestimo) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_emprestimos where idEmprestimo=?");

			stmt.setLong(1, emprestimo.getIdEmprestimo());

			stmt.executeQuery();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public ArrayList<Emprestimo> getEmprestimos() {

		try {
			ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_emprestimos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Editora
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setIdEmprestimo(rs.getLong("idEmprestimo"));
				emprestimo.setNumExemplar(rs.getLong("numExemplar"));

				// montando a data de emprestimo através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);

				// adicionando o objeto à lista
				emprestimos.add(emprestimo);

			}
			rs.close();
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
