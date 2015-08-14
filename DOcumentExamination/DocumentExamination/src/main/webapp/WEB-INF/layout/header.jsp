<%-- 
    Document   : header
    Created on : Jul 8, 2015, 11:15:44 AM
    Author     : VVolgina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<nav>
    <ul>
        <li>
            <s:url value="/documents" var="backURL"/>
            <a href="${backURL}">Документы</a>
        </li>
        <li>
            <s:url value="/reportDoc" var="rep1URL"/>
            <a href="${rep1URL}">Отчет по документам</a>

        </li>
        <li>
            <s:url value="/documentsForUser" var="rep2URL"/>
            <a href="${rep2URL}">Отчет по моим документам</a>
        </li>
        <li>
             <s:url value="/document/edit/${document.id}" var="editURL"/>
            <a href="${editURL}">Добавить документ</a>
        </li>
      
         <li>
             <s:url value="/users" var="usersURL"/>
            <a href="${usersURL}">Пользователи</a>
        </li>
        
        <li>
             <s:url value="/user/edit" var="usersURL"/>
            <a href="${usersURL}">Добавить пользователя</a>
        </li>
    </ul>
</nav>

<div class="headerMain">
    <div id="logo" class="logo">
        <h1>Контроль ознакомления с документами</h1>
    </div>
    <div id="logout" class="logout">
        <form action="" method="post">
            <div>
                <label for="exit" class="text" >Иванов Иван Иванович</label>
                <input type="button" name="exit" class="text" id="exit" value="Выход"/>
            </div>
        </form>
    </div>
</div>

<div class="banner">
    <div class="captions">
        <h2>Lorem ipsum dolor nullam consequat magna sed phasellus.</h2>
    </div>
    <img src="<c:url value="/resources/images/banner.jpg"/>" alt="" class="image"/>
</div>
