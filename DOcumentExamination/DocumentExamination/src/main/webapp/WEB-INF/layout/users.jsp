<%-- 
    Document   : documents
    Created on : May 28, 2015, 11:09:09 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<table class="features-table">
    <tr >
        <th>Фамилия</th>
        <th class="grey">Имя</th>
        <th class="grey">Отчество</th>
        <th class="green">Подробное описание</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr id="document_<c:out value="${user.id}"/>">
            <td>
                <c:out value="${user.surname}"/>
            </td> 
            <td class="grey">
                <c:out value="${user.name}"/>
            </td>

            <td class="grey">
                <c:out value="${user.patronomicname}"/>
            </td>  
            <td class="green">
                <s:url value="/users/${user.id}" var="backURL"/>
                <a href="${backURL}">Просмотр</a>
            </td>
        </tr>
    </c:forEach>
</table>

