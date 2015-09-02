<%-- 
    Document   : document
    Created on : Jun 19, 2015, 11:42:30 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!--Просмотр документа пользователем при ознакомлении-->

<div class="contact_form" >
    <ul>
        <li>
            <h1>Просмотр документа</h1>
            <a href="/<c:out value="${link}"/>" target="_blank"><c:out value="${examination.document.file}"/></a>
        </li>
        <li>
            <label path="name">Название:</label>
            <input path="name" value="${examination.document.name}" disabled="true"/>
        </li>
        <li>
            <label path="number">Номер: </label>
            <input value="${examination.document.number}" disabled="true"/>
        </li>
        <li>
            <label path="description">Краткое описание:</label> 
            <textarea disabled="true">${examination.document.description}</textarea>
        </li>
        <li>
            <label path="typeID">Тип:</label> 
            <input value="${examination.document.documentType.name}" disabled="true"/>
        </li>

        <li>
            <label path="startDate">Дата подписания: </label> 
            <input value="${examination.document.startDate}" disabled="true"/>
        </li>
        <li>
           <sf:form method="POST" commandName="examination">
                  <label path="startDate">Ознакомлен: </label> 
                  <sf:checkbox cssClass="checkbox" path="checked" value="Ознакомлен" onchange="submit();"/>
            </sf:form>
        </li>
        <li>

            <s:url value="/user/documentsForUser" var="backURL"/>
            <a href="${backURL}">Назад</a>
        </li>


        <ul>
            </div>