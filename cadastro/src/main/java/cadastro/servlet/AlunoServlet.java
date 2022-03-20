package cadastro.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/formAluno.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		try {
			switch(acao) {
			case "inserir":
				inserir(request, response);
				break;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

 
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listaAlunos");
//		rd.forward(request, response);
	}
	
	public void inserir(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		AlunoDAO alunoDao = new AlunoDAO();
		Aluno aluno = new Aluno(id, nome, email);
//		aluno.setNome(nome);
//		aluno.setEmail(email);
//		aluno.setId(id);
		
		alunoDao.inserir(aluno);
		
		RequestDispatcher rd = request.getRequestDispatcher("/entrada");
		rd.forward(request, response);
		
//		response.sendRedirect("/WEB-INF/views/listaAlunos.jsp");
	}
}

