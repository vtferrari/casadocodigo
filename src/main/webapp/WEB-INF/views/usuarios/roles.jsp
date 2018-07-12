<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/" var="contextPath"/>

<tags:pageTemplate titulo="Roles">
    <c:url value="/resources/css" var="cssPath"/>
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css"/>
    <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css"/>
    <section id="index-section" class="container middle">

        <h1>Cadastro de permissões para ${usuario.nome}</h1>


        <form:form action="${s:mvcUrl('UC#gravarRoles').build()}" method="post" commandName="usuario">
            <div class="form-group">
                <form:checkboxes  items="${roles}" itemValue="nome" itemLabel="nome" path="roles" />
                <form:hidden path="email" />
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form:form>

    </section>

</tags:pageTemplate>
