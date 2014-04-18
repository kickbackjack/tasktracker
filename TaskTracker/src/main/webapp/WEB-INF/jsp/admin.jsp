<%-- 
    Document   : inspection
    Created on : 10-Apr-2014, 13:50:48
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html class="">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Task Tracker - Administration</title>
        <link type="text/css" rel="stylesheet" href="resources/css/kickstart.css">
        <link type="text/css" rel="stylesheet" href="resources/css/style.css">
        <link type="text/css" rel="stylesheet" href="resources/css/prettify.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <body>
        <jsp:include page="/header"/>

        <h3>Add User</h3>

        <form:form class="vertical" modelAttribute="user_account" action="admin/user" method="POST">
            <div class="col_3">
                <form:label path="fullname">Full Name</form:label>
                <form:input path="fullname" />
                <form:errors path="fullname" cssclass="error"></form:errors>

                <form:label path="email">Email Address</form:label>
                <form:input path="email" />
                <form:errors path="email" cssclass="error"></form:errors>

                <form:label path="windowsName">Windows Account</form:label>
                <form:input path="windowsName" />
                <form:errors path="windowsName" cssclass="error"></form:errors>

                <form:label path="unixName">UNIX Account</form:label>
                <form:input path="unixName" />
                <form:errors path="unixName" cssclass="error"></form:errors>
                
                <input type="submit" value="Submit">
            </div>
        </form:form>
        
        <hr />

        <jsp:include page="/footer"/>
    </body>
</html>
