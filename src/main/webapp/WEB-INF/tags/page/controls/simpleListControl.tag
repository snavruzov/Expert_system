<%@ taglib prefix="ctrl" tagdir="/WEB-INF/tags/page/controls"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="true" %>
<%@ attribute name="action" required="true" %>

<ctrl:listSize>
	<jsp:attribute name="id">${id}</jsp:attribute>
	<jsp:attribute name="value">${value}</jsp:attribute>
</ctrl:listSize>
<jsp:element name="input">
	<jsp:attribute name="id">searchButton</jsp:attribute>
	<jsp:attribute name="type">submit</jsp:attribute>
	<jsp:attribute name="class">button</jsp:attribute>
	<jsp:attribute name="value"><spring:message code="form.submit.refresh"/></jsp:attribute>
</jsp:element>