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
        <th>ФИО</th>
        <th class="grey">Время ознакомления</th>
        <th class="green">Ознакомлен</th>
    </tr>
    <c:forEach items="${examinationLineList}" var="examination">
        <tr id="document_<c:out value="${examination.id}"/>">
            <td>
                <c:out value="${examination.fio}"/>
            </td> 
            <td class="grey">
                <c:out value="${examination.startDate}"/>
            </td>

            <td class="green">
                <img src="<c:url value="/resources/images/${examination.picture}"/>" alt="" class="imageSmall"/>
            </td>  

        </tr>
    </c:forEach>
</table>

