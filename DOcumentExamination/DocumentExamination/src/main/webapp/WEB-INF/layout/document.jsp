<%-- 
    Document   : document
    Created on : Jun 19, 2015, 11:42:30 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="contact_form" >
    <ul>
        <li>
            <h1>Просмотр документа</h1>
            <c:if test="${salary > 2000}">
   <p>My salary is: <c:out value="${salary}"/><p>
</c:if>
            <a href="/<c:out value="${link}"/>" target="_blank"><c:out value="${document.file}"/></a>
        </li>
        <li>
            <label path="name">Название:</label>
            <input path="name" value="${document.name}" disabled="true"/>
        </li>
        <li>
            <label path="number">Номер: </label>
            <input value="${document.number}" disabled="true"/>
        </li>
        <li>
            <label path="description">Краткое описание:</label> 
            <textarea disabled="true">${document.description}</textarea>
        </li>
        <li>
            <label path="typeID">Тип:</label> 
            <input value="${document.documentType.name}" disabled="true"/>
        </li>

        <li>
            <label path="startDate">Дата подписания: </label> 
            <input value="${document.startDate}" disabled="true"/>
        </li>
        <li>

            <s:url value="/director/document/edit/${document.id}" var="editURL"/>
            <a href="${editURL}">Перейти к редактированию</a>
            <s:url value="/director/documents" var="backURL"/>
            <a href="${backURL}">Назад</a>
        </li>


        <ul>
            </div>