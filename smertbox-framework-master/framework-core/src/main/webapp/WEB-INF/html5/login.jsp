<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>${AppCNName} | 登录</title>

    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/font-awesome/css/font-awesome.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/animate.css" rel="stylesheet'/>">
    <link href="<c:url value='/css/style.css" rel="stylesheet'/>">
	<link rel="icon" href="<c:url value='/favicon.ico'/>">
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">FH</h1>
            </div>
            <h3>欢迎来到风暴智盒</h3>
            <p>登录即可体验
            </p>
            <p><!-- Login in. To see it in action. --></p>
            <form:form class="m-t" id="form" role="form" action="${pageContext.request.contextPath}/j_spring_security_check" method="post" >
            	<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
				<input type="hidden" id="_csrf_header" name="_csrf_header" value="${_csrf.headerName}">
            	<c:choose>
	                <c:when test="${error=='logout'}">
	                	<div class="alert alert-info">
		                   	${message}
		                </div>
	                </c:when>
	                <c:when test="${error!=null}">
	                	<div class="alert alert-danger">
		                   	${message}
		                </div>
	                </c:when>
                </c:choose>
                <div class="form-group">
                    <input type="text" class="form-control" value="" id="username" name="username" placeholder="账号" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" value="" id="password" name="password" placeholder="密码" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" value="" id="kaptchaValue" name="kaptchaValue" placeholder="请输入下面的验证码">
                </div>
                <div class="form-group" style="float:left;">
                    <img src="${pageContext.request.contextPath}/kaptcha/image" id="kaptchaImage" />&nbsp;&nbsp;<a href="javascript:void(0);" id="unsee" style="vertical-align:middle;">看不清？换一张</a>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登陆</button>
            </form:form>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="<c:url value='/js/jquery-2.1.1.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript">
		$(function(){
			$("#kaptchaImage").click(function(){
				$('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/kaptcha/image?' + Math.floor(Math.random()*100) ).fadeIn(); 
			});
			
			$("#unsee").click(function(){
				$('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/kaptcha/image?' + Math.floor(Math.random()*100) ).fadeIn(); 
			});
		});
	</script>
</body>

</html>