
<%@page import="com.eteptech.controller.AccountController"%>
<%@include file="../config.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel = "icon" href = "images/cod.jpeg"  type = "image/x-icon"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.9.0.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <section id="wrapper">
    <header id="topHeader">
        
        <section>
            <section class="userlogin"><a>
                <% 
                if(session.getAttribute("AUTHSESSION")!=null){
                    out.println("<a href='logout.jsp' style='color:red'>Logout "+AccountController.getLoggInUser(users).toLowerCase()+"<a>");
                }else {
                    if(session.getAttribute("AUTHSESSION")==null){
                        out.println("<a href='login.jsp' style='color:green;'>"+"Student Login"+"</a>");
            }
         }%>
             </a>
            </section>
                <img src="images/cod.jpeg" alt="site-logo"/>
	    <aside >
	    Erastus.com.
	    </aside>
	</section>
    </header>
	<%@include file="../views/mainNavigation.jsp" %>
	<div id="divMainContent">
	    <section id="mainContent">
	
