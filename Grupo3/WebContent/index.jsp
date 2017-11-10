<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>Trabalho 3</title>
</head>

<h1>Escola "Vida na Prática"</h1>
<h2>Bem-vindo!</h2>
    <div><a href="<c:url value="Computador.jsp"/>">Novo Computador</a></div>
    <div><a href="<c:url value="Monitor.jsp"/>">Novo Monitor</a></div>
    <div><a href="<c:url value="Impressora.jsp"/>">Nova Impressora</a></div>
    <div><a href="<c:url value="Tecnico.jsp"/>">Novo Técnico</a></div>
    <div><a href="<c:url value="Software.jsp"/>">Novo Software</a></div>