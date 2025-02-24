<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Request Parameter</h1>>
<h3>Get 방식의 요청</h3>
<h4>form 태그를 활용한 get 방식 요청</h4>
<form action="querystring" method="get">
    <label for="name">이름: </label><input id = "name" type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
<%--    label+input--%>
    <label>생일: </label><input type="date" name="birthday">
    <br>
    <label>성별: </label>
    <input type="radio" name="gender" id="male" value="M">
    <label for = "male">남자</label>
    <input type="radio" name="gender" id="female" value="F">
    <label for = "female">여자</label>
    <br>
    <label>국적: </label>
    <select name ="national">
<%--        option*4--%>
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
<%--    label+input*3--%>
    <label>취미:</label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label>영화보기</label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label>음악감상</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep"><label>잠자기</label>
    <br>
    <button type="submit">GET 요청</button>
</form>


<h4>a 태그의 href 속성에 직접 파라미터를 써서 쿼리스트링을 작성하고 get을 요청할 수 있다. </h4>
<a href = "http://localhost:8080/chap03/querystring?name=홍길동&age=10&birthday=2025/2/21&national=ko&hobbies=movie&hobbies=music&hobbies=sleep">
    a태그를 활용한 쿼리스트링방식
</a>

<h3>POST 방식의 요청 </h3>
<h4>form 태그를 활용한 get 방식 요청</h4>
<form action="formdata" method="post">
    <label for="name">이름: </label><input id="name" type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <%--    label+input--%>
    <label>생일: </label><input type="date" name="birthday">
    <br>
    <label>성별: </label>
    <input type="radio" name="gender" id="male" value="M">
    <label for="male">남자</label>
    <input type="radio" name="gender" id="female" value="F">
    <label for="female">여자</label>
    <br>
    <label>국적: </label>
    <select name="national">
        <%--        option*4--%>
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <%--    label+input*3--%>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label>영화보기</label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label>음악감상</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep"><label>잠자기</label>
    <br>
    <button type="submit">Post 요청</button>
</form>


</body>
</html>