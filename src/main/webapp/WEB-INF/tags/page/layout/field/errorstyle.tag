<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true" %>
<c:if test="${not empty errors[name]}">${errors[name]}</c:if>
