<%-- 
    Document   : document
    Created on : Jun 19, 2015, 11:42:30 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<c:out value="${document.id}"/>
<div>
    <c:out value="${document.name}"/>
</div>
<div>
    <c:out value="${document.description}"/>
</div>
<s:url value="/document/edit/${document.id}" var="editURL"/>
<a href="${editURL}">Редактировать</a>
<s:url value="/documents" var="backURL"/>
<a href="${backURL}">Назад</a>