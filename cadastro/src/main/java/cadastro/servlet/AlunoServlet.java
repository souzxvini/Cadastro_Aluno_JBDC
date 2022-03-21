package cadastro.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastro.dao.AlunoDAO;
import cadastro.modelo.Aluno;

@WebServlet("/entrada")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		RequestDispatcher rd = request.getRequestDispatcher("/formAluno.jsp");
//		rd.forward(request, response);
//		
//	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		try {
			switch (acao) {
			case "inserir":
				inserir(request, response);
				break;
			case "listar":
				listar(request, response);
				break;
			case "excluir":
				excluir(request, response);
				break;
			case "adicionarAluno":
				formAluno(request, response);
				break;
			case "editar":
				showEditForm(request, response);
				break;
			case "atualizar":
				atualizar(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserir(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");

		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = new Aluno(nome, email);

		alunoDAO.inserir(aluno);

		List<Aluno> alunos = alunoDAO.listar();
		request.setAttribute("listaAlunos", alunos);

		RequestDispatcher dp = request.getRequestDispatcher("/listaAlunos.jsp");
		dp.forward(request, response);
	}

	public void listar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		AlunoDAO alunoDAO = new AlunoDAO();

		List<Aluno> alunos = alunoDAO.listar();
		request.setAttribute("listaAlunos", alunos);

		RequestDispatcher dp = request.getRequestDispatcher("/listaAlunos.jsp");
		dp.forward(request, response);
		
	}

	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Aluno aluno = new Aluno(id);

		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.excluir(aluno);
		List<Aluno> alunos = alunoDAO.listar();
		request.setAttribute("listaAlunos", alunos);
		
		RequestDispatcher dp = request.getRequestDispatcher("/listaAlunos.jsp");
		dp.forward(request, response);
		
	}
	
	public void formAluno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("/formAluno.jsp");
		dp.forward(request, response);
	}
	
	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		

		AlunoDAO alunoDAO = new AlunoDAO();

		Aluno aluno = alunoDAO.selecionarPorId(id);

		// chamando jsp
		
		request.setAttribute("aluno", aluno);
//		return "forward:formEditarAluno.jsp";
		RequestDispatcher dp = request.getRequestDispatcher("/formEditarAluno.jsp");
		
		dp.forward(request, response);
		
	}
	public void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.selecionarPorId(id);

		aluno.setNome(nome);
		aluno.setEmail(email);

//		return "sendRedirect:listar";
//		String nome = request.getParameter("nome");
//		String email = request.getParameter("email");
//		
//
//		AlunoDAO alunoDAO = new AlunoDAO();
//		Aluno aluno = alunoDAO.selecionarPorId(id);
//
//		aluno.setNome(nome);
//		aluno.setEmail(email);
//		
//		
		RequestDispatcher dp = request.getRequestDispatcher("/listaAlunos.jsp");
		dp.forward(request, response);
		
		
	}
	
	

}
