

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Alunos</title>
</head>
<body>
	<div align="center">
	<h1>Alunos Registrados</h1>
		<table width="30%" border="1"  >
			<thead>
				<tr align="center">
					<td>Id</td>
					<td>Nome</td>
					<td>Email</td>
					<td colspan="2">Ações</td>
				</tr>
			 </thead>	
			 <tbody>
			
			 	<c:forEach  items="${listaAlunos}" var="aluno">

					<tr align="center">
					<td>  ${aluno.id} </td>
					<td>  ${aluno.nome}  </td>
					<td>  ${aluno.email}  </td>
					<td> <a href="/cadastro/entrada?acao=excluir&id=${aluno.id}">Excluir</a>  </td>	
					<td> <a href="/cadastro/entrada?acao=editar&id=${aluno.id}">Editar</a>  </td>	
					</tr>			
				</c:forEach>
			 </tbody>
		</table>
		<a href="/cadastro/entrada?acao=cadastroAluno">Adicionar novo aluno</a>

	</div>

</body>
</html>