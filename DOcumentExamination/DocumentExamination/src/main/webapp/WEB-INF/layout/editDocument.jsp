<%-- 
    Document   : editDocument
    Created on : Jul 3, 2015, 11:19:39 AM
    Author     : VVolgina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Редактирование документа</h1>
<sf:form method="POST" commandName="document"  enctype="multipart/form-data">
    <!--выриант отображения ошибок для всей формы сразу sf:errors path="*" element="div"/
    при таком раскладе удобно всем input проставить cssErrorClass, чобы сразу видеть в котором ошибка
    Лейблам класс оформления при ошибке можно проставить точно так же-->
    <sf:label path="name">Название:</sf:label> <sf:input path="name"/> <sf:errors path="name"/><br/>
    <sf:label path="number">Номер: </sf:label><sf:input path="number"/> <sf:errors path="number"/><br/>
        <!--Можно указывать type, таким образом получится использовать теги, специфичесике для Html5
        cssStyle - стиль Css-->
    <sf:label path="description">Краткое описание:</sf:label> <sf:input path="description"/> <sf:errors path="description"/><br/>
    <sf:label path="file">Краткое описание:</sf:label> <input type="file" name="file" accept="doc, docx, pdf"/> <br/>
        <input type="submit" name="ОК"/>


</sf:form>
<!--Следующий тег дописывает адрес из значения до полного, включающего путь сервлета и запоминает
его в переменную, которая может в дальнейшемиспользоваться в ссылках.
МОжно не брать переменную а вмсетонее в свойстве href целиком вставить весь тег URL
Можно добавить параметры, расположив теги param внутри url, 
можно использовать HtmlEscape="true" и сгенерируется не ссылка, а соответствующий ей текст
javaScriotEacape  сделает ссылку в витде подходящем для JavaScript-->
<s:url value="/documents" var="backURL"/>
<a href="${backURL}">Назад</a>

