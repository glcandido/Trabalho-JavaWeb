<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabalho 3</title>
</head>
<body>
	<h1>Escola "A vida na prática"</h1>
	<h2>Cadastro de Impressoras</h2>
	<hr>
	<br>
	<form method="post" action="CadastroTecnicoController">
		<div>
			<input type="hidden" id="id" name="id" value="${paramId}">
		</div>
		<div>
			<label for="Nome">Nome: &nbsp;</label>
			<input type="text" id="Nome" name="Nome" value="${paramNome}">
		</div>
		<div>
			<label for="CPF">CPF: &nbsp; &nbsp;</label>
			<input type="text" id="CPF" name="CPF" value="${paramCPF}">
		</div>
		<div>
			<label for="dt_Nasc">Data de Nascimento: &nbsp;</label>
			<input type="date" id="dt_Nasc" name="dt_Nasc" value="${paramdt_Nasc}"><br><br>
		</div>
		<div>
			<input type="submit" value="Salvar">
		</div>
	</form>
</body>
</html>