<%-- 
    Document   : login
    Created on : Sep 1, 2015, 3:26:08 PM
    Author     : VVolgina
--%>
<div id="content">

    <a th:href="@{/spitter/register}">Register</a>


    <form name='f' action='/login' method='POST'>
        <table>
            <tr>
                <td>
                    User:
                </td>
                <td>
                    <input type='text' name='username' value='' />
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <input type='password' name='password'/>
                </td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="????"/>
                </td>
            </tr>
        </table>
    </form>
</div>
