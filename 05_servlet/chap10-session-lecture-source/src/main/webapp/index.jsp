<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Session Handling</h1>
<form action="session" method="post">
    <table style="margin:auto">
        <tr>
            <td>firstName</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>lastName:</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">전송</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<body>
        <h3>필터의 활용</h3>
        <form action="member/regist" method="post"></form>
            <%--label{아이디: }--%>
        <label>아이디: </label>
        <input type="text" name="userId">
<br>
        <label>비밀번호: </label>
        <input type="password" name="password">
        <br>
        <label>이름: </label>
        <input type="text" name="password">
        <br>
        <button>가입하기</button>
    </form>
</body>