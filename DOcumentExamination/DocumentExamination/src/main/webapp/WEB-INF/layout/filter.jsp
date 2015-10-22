<%-- 
    Document   : documents
    Created on : May 28, 2015, 11:09:09 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form method="POST" commandName="dateFilter" cssClass="contact_form1">
    <ul>
        <li>
            <h1>Фильтрация по дате регистрации документа</h1>
        </li>
        <li>
            <sf:label path="fromString">C: </sf:label> <sf:input cssClass="on_top" path="fromString" type="text" onfocus="this.select();lcs(this)"  onclick="event.cancelBubble=true;this.select();lcs(this)" class="calendar3"/>
             <sf:label path="toString">По: </sf:label> <sf:input cssClass="on_top" path="toString" type="text" onfocus="this.select();lcs(this)"  onclick="event.cancelBubble=true;this.select();lcs(this)" class="calendar3"/>
        </li>
         <li>
                <button class="submit" type="submit" name="OK">ОК</button>
         </li>
    </ul>
</sf:form>
