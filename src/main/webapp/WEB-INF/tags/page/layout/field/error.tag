<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true" %>

<c:if test="${not empty errors[name]}">
    <span class="error"><spring:message code="${errors[name]}" /></span>
</c:if>
