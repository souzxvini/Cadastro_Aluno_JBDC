package cadastro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cadastro.modelo.Aluno;

public class AlunoDAO {

	// Estabelecer url do mysql
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
	
	private String jdbcUsuario = "root";
	private String jdbcSenha = "Aeradogelo3@";

	private String INSERIR_ALUNO = "INSERT INTO ALUNOS (nome, email) values (?, ?);";
	private String EXCLUIR_ALUNO = "DELETE FROM ALUNOS WHERE ID = ?";
	private String SELECIONAR_ALUNOS = "SELECT * FROM ALUNOS;";
	private String SELECIONAR_ALUNO_PELO_ID = "SELECT * FROM ALUNOS WHERE ID = ?;";
	private String ATUALIZAR_ALUNO = "UPDATE ALUNOS SET NOME= ?, EMAIL= ? WHERE ID = ?;";
	
	// Estabelecer a Connection
	protected Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsuario, jdbcSenha);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// criar funções

	public void inserir(Aluno aluno) throws SQLException {
		try (Connection connection = getConnection()) {
		    try(PreparedStatement stm = 
				connection.prepareStatement(INSERIR_ALUNO, Statement.RETURN_GENERATED_KEYS)){
			
			stm.setString(1, aluno.getNome());
			stm.setString(2,  aluno.getEmail());
			
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()){
				while(rst.next()) {
					aluno.setId(rst.getInt(1));
				}
			}
		}
		}
		
	}

	public boolean excluir(	Aluno aluno) throws SQLException {

		try (Connection connection = getConnection()) {
			boolean linhasAfetadas;
			try (PreparedStatement stm = connection.prepareStatement(EXCLUIR_ALUNO)) {
				stm.setInt(1, aluno.getId());
			
				linhasAfetadas = stm.executeUpdate() > 0;

			}
			return linhasAfetadas;
		}
	}

	public List<Aluno> listar() throws SQLException {

		List<Aluno> alunos = new ArrayList<>();

		try (Connection connection = getConnection()) {
			try (PreparedStatement stm = connection.prepareStatement(SELECIONAR_ALUNOS)) {

				ResultSet rs = stm.executeQuery();

				while (rs.next()) {
					Integer id = rs.getInt("id");
					String nome = rs.getString("nome");
					String email = rs.getString("email");

					alunos.add(new Aluno( id, nome, email));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return alunos;
		}
	}

	public Aluno selecionarPorId(int id) throws SQLException {
		
		Aluno aluno = new Aluno();
		try (Connection connection = getConnection()) {
			
			try (PreparedStatement stm = connection.prepareStatement(SELECIONAR_ALUNO_PELO_ID)) {
				stm.setInt(1, id);
				
				ResultSet rs = stm.executeQuery();

				while (rs.next()) {
					aluno.setId(rs.getInt("id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return aluno;
			
		}
	}

	public void atualizar(Aluno aluno) {
		
		try (Connection connection = getConnection()) {
			try (PreparedStatement stm = connection.prepareStatement(ATUALIZAR_ALUNO)) {

				stm.setString(1, aluno.getNome());
				stm.setString(2, aluno.getEmail());
				stm.setInt(3, aluno.getId());
				
				stm.executeUpdate();
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
	}

}
