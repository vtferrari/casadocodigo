<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:url value="/" var="contextPath"/>

<tags:pageTemplate titulo="Pedidos">
    <section id="index-section" class="container middle">

        <h1>Lista de pedidoDTOS atuais</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Valor</th>
                <th>DataPedido</th>
                <th>Titulos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td>${pedido.id}</td>
                    <td><fmt:formatNumber type="number" pattern="#,###.##" value="${pedido.valor}" /></td>
                    <td><fmt:formatDate value="${pedido.data.time }" pattern="dd/MM/yyyy"/></td>
                    <td>
                        <c:forEach items="${pedido.produtos}" var="produto" varStatus="status">
                            ${produto.titulo}
                            <c:if test="${!status.last}">
                                ,
                            </c:if>

                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </section>

</tags:pageTemplate>