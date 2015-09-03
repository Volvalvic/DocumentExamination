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
        <th>Название документа</th>
        <th class="grey">Номер документа</th>
        <th class="grey">Тип документа</th>
        <th class="green">Подробное описание</th>
    </tr>
    <c:forEach items="${documentList}" var="document">
        <tr id="document_<c:out value="${document.id}"/>">
            <td>
                <c:out value="${document.name}"/>
            </td> 
            <td class="grey">
                <c:out value="${document.number}"/>
            </td>

            <td class="grey">
                <c:out value="${document.documentType.name}"/>
            </td>  
            <td class="green">
        <s:url value="/director/document/${document.id}" var="backURL"/>
        <a href="${backURL}">Просмотр</a>
    </td>
</tr>
</c:forEach>
</table>

