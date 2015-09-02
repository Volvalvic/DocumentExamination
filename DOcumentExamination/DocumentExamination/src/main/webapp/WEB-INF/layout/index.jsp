<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<h2>Добро пожаловать в систему контроля ознакомления с документами</h2>
<security:authorize access="not isAuthenticated()"><s:url value="/login" var="enter"/>
    <a class="submit" href="${enter}">Вход</a>
</security:authorize>
