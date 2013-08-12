<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="true" %>

<spring:message code="field.list.size" />:&nbsp;<input id="${id}" type="text" style="width:20px;" maxlength="4" value="${value}" name="${id}"/>