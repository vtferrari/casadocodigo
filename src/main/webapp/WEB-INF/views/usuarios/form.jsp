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

        <h1>Cadastro de Usuario</h1>

        <form:form action="${s:mvcUrl('UC#gravar').build()}" method="post" commandName="usuario">
            <div class="form-group">
                <label>Nome</label>
                <form:input path="nome" cssClass="form-control"/>
                <form:errors path="nome"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email"/>
            </div>
            <div class="form-group">
                <label>Senha</label>
                <form:password path="senha" cssClass="form-control"/>
                <form:errors path="senha"/>
            </div>
            <div class="form-group">
                <label>Confirmação de Senha</label>
                <form:password path="senhaConfirmacao" cssClass="form-control"/>
                <form:errors path="senhaConfirmacao"/>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form:form>


    </section>

</tags:pageTemplate>
