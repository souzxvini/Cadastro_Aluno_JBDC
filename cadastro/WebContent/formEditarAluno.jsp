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
		<form method="get" action="${linkEntradaServlet}" >
			
				<h1>Editar Aluno</h1>
				
                <input type="hidden" name="id"  value="${aluno.id}">
				<label>Name:</label> 
				<input type="text" name="nome"   value="${aluno.nome}"/><br /> <label>Email:</label>
				<input type="email" name="email"  value="${aluno.email}" /><br /><br />
				
				<input type="hidden" name="acao" value="atualizar">
				<input type="submit" value="atualizar"> 
				<a href="/cadastro/entrada?acao=listar">Voltar</a>
				
		</form>
	</div>
</body>
</html>