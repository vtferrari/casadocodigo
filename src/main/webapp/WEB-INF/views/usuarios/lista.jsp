<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/" var="contextPath"/>

<tags:pageTemplate titulo="Pedidos">
	<c:url value="/resources/css" var="cssPath"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css"/>
	<section id="index-section" class="container middle">

		<h1>Lista de Produtos</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${usuarios }" var="usuario">
				<tr>
					<td>${usuario.nome} </td>
					<td>${usuario.email }</td>
				</tr>
			</c:forEach>
		</table>

	</section>

</tags:pageTemplate>
