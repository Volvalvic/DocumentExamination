<%-- 
    Document   : documents
    Created on : May 28, 2015, 11:09:09 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- Список документов для данного пользователя-->
<table class="features-table">
    <tr >
        <th>Название документа</th>
        <th class="grey">Номер документа</th>
        <th class="grey">Ознакомлен</th>
        <th class="green">Подробное описание</th>
    </tr>
    <c:forEach items="${examinationLineList}" var="examination">
        <tr id="document_<c:out value="${examination.id}"/>">
            <td>
                <c:out value="${examination.name}"/>
            </td> 
            <td class="grey">
                <c:out value="${examination.number}"/>
            </td>

            <td class="grey">
                <img src="<c:url value="/resources/images/${examination.picture}"/>" alt="" class="imageSmall"/>
            </td>  
            <td class="green">
        <s:url value="/user/documentRead/${examination.id}" var="backURL"/>
        <a href="${backURL}">Просмотр</a>
    </td>
</tr>
</c:forEach>
</table>

