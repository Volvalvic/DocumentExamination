<%-- 
    Document   : documents
    Created on : May 28, 2015, 11:09:09 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<a href="<c:out value="/${file}"/>" target="_blank" class="download">Отчет</a>
<table class="features-table">
    <tr >
        <th>Название документа</th>
        <th class="grey">Номер документа</th>
        <th class="grey">Дата регистрации</th>
        <th class="grey">Ознакомилось</th>
        <th class="grey">Не ознакомилось</th>
        <th class="green">Подробнее</th>
    </tr>
    <c:forEach items="${documentLineList}" var="document">
        <tr id="document_<c:out value="${document.id}"/>">
            <td>
                <c:out value="${document.name}"/>
            </td> 
            <td class="grey">
                <c:out value="${document.num}"/>
            </td>
            <td class="grey">
                <c:out value="${document.registrationDate}"/>      
            </td>  
            <td class="grey">
                <c:out value="${document.checked}"/>
            </td>  
            <td class="grey">
                <c:out value="${document.unchecked}"/>
            </td>  
            <td class="green">
                <s:url value="/director/usersForDocument/${document.id}" var="backURL"/>
                <a href="${backURL}">Ознакомленные</a>
            </td>
        </tr>
    </c:forEach>
</table>


