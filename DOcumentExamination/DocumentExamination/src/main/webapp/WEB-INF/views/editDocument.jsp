<%-- 
    Document   : editDocument
    Created on : Jul 3, 2015, 11:19:39 AM
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
        <h1>Редактирование документа</h1>
        <form method="POST">
            Название: <input type="text" name="name"/><br/>
            Номер: <input type="text" name="number"/><br/>
            Краткое описание: <input type="text" name="description"/><br/>
            <input type="submit" name="ОК"/>
        </form>
    </body>
</html>
