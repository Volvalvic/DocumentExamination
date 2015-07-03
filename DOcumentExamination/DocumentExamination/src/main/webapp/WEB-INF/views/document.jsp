<%-- 
    Document   : document
    Created on : Jun 19, 2015, 11:42:30 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="keywords" content="ЕСПП, документ, распоряжение, телеграмма, ознакомление, отчет, контроль"/>
        <meta name="description" content="Система контроля ознакомления с документами для ЕСПП"/>
        <meta name="author" content="Волгина Валерия Викторовна, Рабееах Светлана Александровна"/>
        <title>Ознакомление с документами</title>        
        <link rel="stylesheet"  href="<c:url value="/resources/Main.css"/>"/>
        <script src="<c:url value="/resources/js/main.js"/>"></script>
    </head>
    <body>
        <c:out value="${document.id}"/>
        <div>
            <c:out value="${document.name}"/>
        </div>
        <div>
            <c:out value="${document.description}"/>
        </div>
    </body>
</html>
