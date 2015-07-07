<%-- 
    Document   : editDocument
    Created on : Jul 3, 2015, 11:19:39 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
        <sf:form method="POST" commandName="document">
            <!--выриант отображения ошибок для всей формы сразу sf:errors path="*" element="div"/
            при таком раскладе удобно всем input проставить cssErrorClass, чобы сразу видеть в котором ошибка
            Лейблам класс оформления при ошибке можно проставить точно так же-->
            <sf:label path="name">Название:</sf:label> <sf:input path="name"/> <sf:errors path="name"/><br/>
            <sf:label path="number">Номер: </sf:label><sf:input path="number"/> <sf:errors path="number"/><br/>
            <!--Можно указывать type, таким образом получится использовать теги, специфичесике для Html5
            cssStyle - стиль Css-->
            <sf:label path="description">Краткое описание:</sf:label> <sf:input path="description"/> <sf:errors path="description"/><br/>
            <input type="submit" name="ОК"/>
        </sf:form>
    </body>
</html>
