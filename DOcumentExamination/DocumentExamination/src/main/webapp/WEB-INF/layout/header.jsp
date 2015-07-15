<%-- 
    Document   : header
    Created on : Jul 8, 2015, 11:15:44 AM
    Author     : VVolgina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <li class="first">
            <a href="#">Resources</a>
        </li>
        <li>
            <a href="#">Links</a>
        </li>
        <li>
            <a href="#">Services</a>
        </li>
        <li>
            <a href="#">About</a>
        </li>
        <li>
            <a href="#">Downloads</a>
        </li>
        <li>
            <a href="#">Blog</a>
        </li>
        <li>
            <a href="#">Portfolio</a>
        </li>
        <li>
            <a href="#">Contact</a>
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
