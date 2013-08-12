<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="true" %>

<c:if test="${not empty values[id]}">${values[id]}</c:if>
<c:if test="${empty values[id]}">${value}</c:if>
