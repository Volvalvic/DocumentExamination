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
<!-- target="_blank" открытие в новой вкладке-->
<a href="<c:out value="${documentForm.filePath}"/>" target="_blank">Загрузить файл</a>
<sf:form method="POST" commandName="documentForm"  enctype="multipart/form-data">
    <!--выриант отображения ошибок для всей формы сразу sf:errors path="*" element="div"/
    при таком раскладе удобно всем input проставить cssErrorClass, чобы сразу видеть в котором ошибка
    Лейблам класс оформления при ошибке можно проставить точно так же-->
    <sf:label path="name">Название:</sf:label> <sf:input path="name"/> <sf:errors path="name"/><br/>
    <sf:label path="number">Номер: </sf:label><sf:input path="number"/> <sf:errors path="number"/><br/>
        <!--Можно указывать type, таким образом получится использовать теги, специфичесике для Html5
        cssStyle - стиль Css-->
    <sf:label path="startDate">Дата подписания: </sf:label> <sf:input path="startDate" type="text" value="dd-mm-yy" onfocus="this.select();lcs(this)"  onclick="event.cancelBubble=true;this.select();lcs(this)" class="calendar3"/>  <sf:errors path="startDate"/><br/>
    <sf:label path="description">Краткое описание:</sf:label> <sf:textarea path="description"/> <sf:errors path="description"/><br/>
    <sf:label path="typeID">Тип документа:</sf:label> <sf:select path="typeID">  
        <sf:options items="${types}" itemLabel="name" itemValue="id"/>
    </sf:select></br>
    <sf:input type="file" path="file" accept="application/msword, application/pdf, application/rtf, application/excel, image/bmp, image/gif, image/jpeg, image/png, image/tiff"/> 

    <sf:hidden path="fileName"/><br/>
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

