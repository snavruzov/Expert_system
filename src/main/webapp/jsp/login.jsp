<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <meta http-equiv="Expires" content="Tue, 12 May 1962 1:00:00 GMT" />
	    <meta http-equiv="Pragma" content="no-cache" />
	    <meta http-equiv="Cache-Control" content="no-cache" />

	    <title>${title}</title>

        <style type="text/css">
		input {
			border:1px solid #CCCCCC;
			cursor:pointer;
			margin-top:1px;
			padding:0;
			width:125px;
		}
		.submitbutton {
			background:url("img/button_line.png") repeat-x scroll 0 0 transparent;
			border:1px solid white;
			color:white;
			margin:2px 0;
			padding:2px 0;
		}
	</style>

	<c:set var="submitButtonText"><spring:message code="site.login.enter" /></c:set>
	</head>
	<body>
        <center style="padding:100px 0;">
        <h2 style="color: #0166e4;">Expert System</h2>
		<form method="post" action="${pageContext.request.contextPath}/j_security_check" style="padding-top: 10px;">
			<input type="text" name="j_username"/><br/>
			<input type="password" name="j_password"/><br/>
			<input type="submit" value="${submitButtonText}"  class="submitbutton" />
		</form>
	    </center>
	</body>
</html>
