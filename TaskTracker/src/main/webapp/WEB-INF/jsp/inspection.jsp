<%-- 
    Document   : inspection
    Created on : 10-Apr-2014, 13:50:48
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Task Tracker - Home</title>
        <link type="text/css" rel="stylesheet" href="resources/css/kickstart.css">
        <link type="text/css" rel="stylesheet" href="resources/css/style.css">
        <link type="text/css" rel="stylesheet" href="resources/css/prettify.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <body>
        <jsp:include page="/header"/>

        <label for="search">Search </label>
        <input id="search" type="text" placeholder="e.g. PTR/IDT Number" />

        <jsp:include page="/footer"/>
    </body>
</html>
