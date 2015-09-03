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
            <h1>Просмотр пользователя</h1>
        </li>
        <li>
            <label>Фамилия:</label>
            <input value="${user.surname}" disabled="true"/>
        </li>
        <li>
            <label>Имя: </label>
            <input value="${user.name}" disabled="true"/>
        </li>
        <li>
            <label>Отчество:</label> 
            <input  value="${user.patronomicname}" disabled="true" />
        </li>
        <li>
            <label>Номер телефона:</label> 
            <input value="${user.phoneNumber}" disabled="true"/>
        </li>

        <li>
            <label>Дополнительная информация: </label> 
            <textarea  disabled="true">${user.additionalInfo}</textarea>
        </li>
        
        <li>
            <label path="startDate">Отдел: </label> 
            <input value="${user.department.name}" disabled="true"/>
        </li>
        
        <li>
            <s:url value="/admin/users" var="backURL"/>
            <a href="${backURL}">Назад</a>
            <s:url value="/admin/user/edit/${user.id}" var="editURL"/>
            <a href="${editURL}">Перейти к редактированию</a>

        </li>


        <ul>
            </div>