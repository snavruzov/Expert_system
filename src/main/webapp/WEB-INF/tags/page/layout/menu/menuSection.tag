<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="title" required="false" %>

<div class="caption"><spring:message code="${title}"/></div>
<div class="mlink">
	<jsp:doBody />
</div>
<br/>