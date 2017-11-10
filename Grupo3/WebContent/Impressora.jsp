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
	<form method="post" action="CadastroImpressoraController">
		<div>
			<input type="hidden" id="id" name="id" value="${paramId}">
		</div>
		<div>
			<label for="Marca">Marca: &nbsp; &nbsp;</label>
			<input type="text" id="Marca" name="Marca" value="${paramMarca}">
		</div>
		<div>
			<label for="Modelo">Modelo: &nbsp;</label>
			<input type="text" id="Modelo" name="Modelo" value="${paramModelo}">
		</div>
		<div>
			<label for="Garantia">Garantia: &nbsp;</label>
			<input type="date" id="Garantia" name="Garantia" value="${paramGarantia}">
		</div>
		<div>
			<label for="dt_Compra">Data da Compra: </label>
			<input type="date" id="dt_Compra" name="dt_Compra" value="${paramdt_Compra}"><br><br>
		</div>
		<div>
			<input type="submit" value="Salvar">
		</div>
	</form>
</body>
</html>