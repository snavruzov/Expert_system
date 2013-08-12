<%@ include file="/jsp/taglibs.jsp" %>

<%@ attribute name="title" %>
<%@ attribute name="topsList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Expires" content="Tue, 12 May 1962 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>


    <inline:css/>
    <inline:js/>
</head>

<body>
<sec:authorize access="isAuthenticated()">

    <div class="DialogContainer InputDialog global-ui-popup">
            <jsp:doBody />
    </div>

</sec:authorize>
<sec:authorize access="isAnonymous()">
    <jsp:doBody/>
</sec:authorize>
</body>
</html>




