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
	<form method="post" action="CadastroSoftwareController">
		<div>
			<input type="hidden" id="id" name="id" value="${paramId}">
		</div>
		<div>
			<label for="Nome">Nome: &nbsp; &nbsp;</label>
			<input type="text" id="Nome" name="Nome" value="${paramNome}">
		</div>
		<div>
			<label for="Versaoo">Versão:&nbsp; &nbsp;</label>
			<input type="text" id="Versao" name="Versao" value="${paramVersao}">
		</div>
		<div>
			<label for="Licenca">Licença: &nbsp;</label>
			<input type="text" id="Licenca" name="Licenca" value="${paramLicenca}"><br><br>
		</div>
		<div>
			<input type="submit" value="Salvar">
		</div>
	</form>
</body>
</html>