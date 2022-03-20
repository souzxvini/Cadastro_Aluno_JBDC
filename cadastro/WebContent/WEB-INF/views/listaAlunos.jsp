<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Alunos</title>
</head>
<body>
	<div align="center">
		<table >
			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td>Email</td>
				
				<td>Comandos</td>
			</tr>
			<c:forEach var="aluno" items="${listaAluno}">
				<tr>
					<td>${aluno.matricula}</td>
					<td>${aluno.nome}</td>
					<td>${aluno.telefone}</td>
					 
					<td><a href="entrada?acao=Excluir&id=${aluno.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaAluno) > 0}">
   		Existem ${fn:length(listaAluno)} alunos!
 		</c:if><br> 		
	</div>
 
</body>
</html>