<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Aluno</title>
</head>
<body>
	<div align="center">
		<form method="post" action="<%=request.getContextPath()%>/entrada">
			<fieldset>
				<legend>Cadastro de Alunos</legend>

				<label>Id:</label> <input type="text" name="id" }" required /><br /> 
				<label>Name:</label> 
				<input type="text" name="nome" required /><br /> <label>Email:</label>
				<input type="email" name="email" required /><br />
<%-- 				<input type="hidden" name="id" value="${aluno.id }"> --%>


				<!-- 					<label>Ação</label> -->
				<!-- 				<select name="acao" required> -->
				<!-- 					<option selected value="inserir">Inserir</option> -->
				<!-- 					<option value="Alterar">Alterar</option> -->
				<!-- 					<option value="Excluir">Excluir</option> -->
				<!-- 					<option value="Consultar">Consultar</option> -->
				<!-- 				</select><br /> <input type="submit" value="Enviar">  -->

				<input type="submit" name="acao" value="inserir">

				<!-- Super importante	 -->
<!-- 				<input type="hidden" name="acao" value="inserir"> -->
				
			</fieldset>
		</form>
	</div>
</body>
</html>