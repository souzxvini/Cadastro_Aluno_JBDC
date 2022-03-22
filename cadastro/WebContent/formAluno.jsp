<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<html lang="pt">
<head>
<title>Cadastro de Aluno</title>
</head>
<body>
	<div align="center">
		<form method="post" action="${linkEntradaServlet}"  >
			
				<h1>Cadastro de Alunos</h1>
			
				 <input type="hidden" name="id" value="${aluno.id }">
				 
				<label>Name:</label> 
				<input type="text" name="nome" required /><br /> <label>Email:</label>
				<input type="email" name="email" required /><br /><br />
				
				<input type="submit" name="acao" value="inserir">
<!-- 				<input type="submit" name="acao" value="listar"> -->
				<a href="/cadastro/entrada?acao=listar">Listar alunos</a>
				

				<br>
				
		</form>
	</div>
</body>
</html>