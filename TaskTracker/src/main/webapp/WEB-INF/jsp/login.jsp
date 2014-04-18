<%-- 
    Document   : inspection
    Created on : 10-Apr-2014, 13:50:48
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Task Tracker - Login</title>
        <link type="text/css" rel="stylesheet" href="resources/css/kickstart.css">
        <link type="text/css" rel="stylesheet" href="resources/css/style.css">
        <link type="text/css" rel="stylesheet" href="resources/css/prettify.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <body>
        <jsp:include page="/header"/>


        <form name="login_form" action="<c:url value='j_spring_security_check' />" method="POST">
            <label for="j_username">Email:</label>
            <input id="j_username" name="j_username" class="input_field" type="text" value="<c:if test="${not empty error}"><c:out value="${sessionScope.SPRING_SECURITY_LAST_USERNAME}" escapeXml="false"/></c:if>" placeholder="mail@address.com" />

        <label for="j_password">Password:</label>
        <input id="j_password" name="j_password" class="input_field" type="password" />

        <input type="submit" class="button_input form_submit" name="submit" value="Login"/>

        <div class="form_error" id="login" >
            <c:if test="${not empty login_error}">
                Login failed<br /> Caused :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </c:if>
        </div>
    </form>

    <jsp:include page="/footer"/>
</body>
</html>
