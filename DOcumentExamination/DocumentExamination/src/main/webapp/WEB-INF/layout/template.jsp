<%-- 
    Document   : template
    Created on : Jul 7, 2015, 5:20:54 PM
    Author     : VVolgina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="keywords" content="ЕСПП, документ, распоряжение, телеграмма, ознакомление, отчет, контроль"/>
        <meta name="description" content="Система контроля ознакомления с документами для ЕСПП"/>
        <meta name="author" content="Волгина Валерия Викторовна, Рабееах Светлана Александровна"/>
        <title>АС КИМ КЦ</title>       
        <!--[if lt IE 9]>
<script>
var e = ("article,aside,figcaption,figure,footer,header,hgroup,nav,section,time").split(',');
for (var i = 0; i < e.length; i++) {
document.createElement(e[i]);
}
</script>
<![endif]-->
        <link rel="stylesheet"  href="<c:url value="/resources/Main.css"/>"/>
        <script src="<c:url value="/resources/js/main.js"/>"></script>
        <link rel="stylesheet"  href="<c:url value="/resources/Calendar.css"/>"/>
        <script src="<c:url value="/resources/js/Calendar.js"/>"></script>
    </head>
    <body>
        <header>
            <t:insertAttribute name="header"/>
        </header>
        <article>
            <t:insertAttribute name="body"/>
        </article>
        <footer>
            <t:insertAttribute name="footer"/>
        </footer>
    </body>
</html>
