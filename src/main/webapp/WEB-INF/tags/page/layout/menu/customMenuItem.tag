<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="title" required="true" %>
<%@ attribute name="url" required="true" %>

<c:url value="${url}" var="href" scope="page" />
<div><a href="${href}">${title}</a></div>