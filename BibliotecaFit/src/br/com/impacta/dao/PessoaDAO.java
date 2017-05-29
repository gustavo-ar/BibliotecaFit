package br.com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.impacta.model.Pessoa;
import br.com.impacta.sql.ConnectionFactory;

public class PessoaDAO {

	private Connection connection;

	public PessoaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Pessoa pessoa) {

		String sql = "insert into tb_pessoas" + "(idPessoa,nome,email,telefone,dataRegisto,cpf,senha,inadmin)"
				+ "values (?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, pessoa.getIdPessoa());
			stmt.setString(2, pessoa.getNome());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getTelefone());
			stmt.setDate(5, (java.sql.Date) new Date(pessoa.getDataRegisto().getTimeInMillis()));
			stmt.setString(6, pessoa.getCpf());
			stmt.setString(7, pessoa.getSenha());
			stmt.setBoolean(8, pessoa.isInadmin());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Pessoa pessoa) {

		String sql = "update tb_pessoas set nome=?, email=?, telefone=?, dataRegistro=?, cpf=?, senha=?, inadimin=? where idPessoa=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getTelefone());
			stmt.setDate(4, (java.sql.Date) new Date(pessoa.getDataRegisto().getTimeInMillis()));
			stmt.setString(5, pessoa.getCpf());
			stmt.setString(6, pessoa.getSenha());
			stmt.setBoolean(7, pessoa.isInadmin());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Pessoa pessoa) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_pessoas where idPessoa=?");
			stmt.setLong(1, pessoa.getIdPessoa());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Pessoa> getPessoas() {

		try {
			ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tb_pessoas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Obra
				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getLong("idPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setTelefone(rs.getString("telefone"));
				
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setInadmin(rs.getBoolean("inadimin"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataRegistro"));
				pessoa.setDataRegisto(data);
			

				// adicionando o objeto à lista
				pessoas.add(pessoa);
			}
			rs.close();
			stmt.close();
			return pessoas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
