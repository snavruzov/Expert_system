<%@ include file="/jsp/taglibs.jsp"%>

<%@ attribute name="title" %>
<%@ attribute name="topsList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns = "http://www.w3.org/1999/xhtml" xml:lang = "en">

<head>
    <title></title>
    <meta http-equiv = "Content-Type" content = "text/html;charset=utf-8" />
    <link rel = "stylesheet" href = "css/style.css" media = "all" />
</head>

<body>

<!--wrapper begin-->
<div class = "wrapper">

    <!--header begin-->
    <div class = "header">

        <!--header-left begin-->
        <div class="header-left">
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/ai/about_me"><spring:message code="section.ai.menu.top.aboutme"/></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/ai/about_app"><spring:message code="section.ai.menu.top.aboutapp"/></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/contact"><spring:message code="section.ai.menu.top.contact"/></a>
                </li>
            </ul>
        </div>
        <!--header-left end-->

        <!--header-right begin-->
        <div class="header-right">
            <h1>
                <a href="index.html">
                    <spring:message code="site.provider.title"/>
                </a>
            </h1>
            <p><spring:message code="site.provider.provider"/></p>
        </div>
        <!--header-right end-->

    </div>
    <!--header end-->

    <div class="clearfix"></div>

    <!--content begin-->
    <div class = "content">

        <!--sidebar begin-->
        <div class="sidebar">
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/ai/weight"><spring:message code="section.ai.menu.weights"/></a>
                </li>
                <li>
                    <a href="function.html"><spring:message code="section.ai.menu.func"/></a>
                </li>
                <li>
                    <a href="object.html"><spring:message code="section.ai.menu.recognition"/></a>
                </li>
                <li>
                    <a href="report.html"><spring:message code="section.ai.menu.report"/></a>
                </li>
            </ul>
        </div>
        <!--sidebar end-->
        <sec:authorize access="isAuthenticated()">
		  	<!--content__inner begin-->
                <div class="content__inner">
                    <jsp:doBody />
                </div>
            <!--content__inner end-->
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<jsp:doBody />
		</sec:authorize>
        <div class="clearfix"></div>
    </div>
    <!--content end-->

</div>
<!--wrapper end-->

</body>
</html>




