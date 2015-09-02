<%-- 
    Document   : login
    Created on : Sep 1, 2015, 3:26:08 PM
    Author     : VVolgina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="content">
    <form name='f' action='/DocumentExamination/login' method='POST' class="contact_form">
        <ul>
            <li>
                <h1>Авторизация</h1>
            </li>
            <li>
                <label>
                    Логин:
                </label>

                <input type='text' name='username' value='' />
            </li>
            <li>
                <label>
                    Пароль:
                </label>
                <input type='password' name='password'/>
            </li>
            <li>
                <!--Нужно для безопасности. проверяется наличие csrf токена, чтобы не выполнялись запросы с других сайтов.
                В формы spring он добавляется автоматически. но здесь, так как используется форма html, приходится вставлять вручную-->
                <input type='hidden' name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="submit" name="submit" type="submit">Вход</button>
            </li>
    </form>
</div>
