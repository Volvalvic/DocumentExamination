<%-- 
    Document   : documents
    Created on : May 28, 2015, 11:09:09 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <ul>
            <c:forEach items="${documentList}" var="document">
                <li id="document_<c:out value="${document.id}"/>">
                    <div>
                        <c:out value="${document.name}"/>
                    </div>
                    <div>
                        <c:out value="${document.description}"/>
                    </div>
                </li>
            </c:forEach>
        </ul>

