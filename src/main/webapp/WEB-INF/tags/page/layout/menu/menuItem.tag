<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="title" required="true" %>
<%@ attribute name="url" required="false" %>
<%@ attribute name="nolink" required="false" %>
<%@ attribute name="line" required="false" %>

<c:choose>
	<c:when test="${line == true}">
		<span style="padding-left:7px;">
			<c:choose>
				<c:when test="${not nolink}">
					<c:url value="${url}" var="href" scope="page" />
					<a href="${href}"><spring:message code="${title}"/></a>
				</c:when>
				<c:otherwise>
					<spring:message code="${title}"/>
				</c:otherwise>
			</c:choose>
		</span>
	</c:when>
	<c:otherwise>
		<div>
			<c:choose>
				<c:when test="${not nolink}">
					<c:url value="${url}" var="href" scope="page" />
					<a href="${href}"><spring:message code="${title}"/></a>
				</c:when>
				<c:otherwise>
					<spring:message code="${title}"/>
				</c:otherwise>
			</c:choose>
		</div>
	</c:otherwise>
</c:choose>