<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ attribute name="action" required="true" %>
<%@ attribute name="pagesCount" required="true" %>
<%@ attribute name="currentPage" required="true" %>
<%@ attribute name="showall" required="false" %>
<%@ attribute name="listSize" %>

<div class="pages">
	<c:if test="${currentPage>2}">
		<span class="page" page="1">&lt;&lt;</span>
	</c:if>
	<c:if test="${currentPage>1}">
		<span class="page" page="${currentPage-1}">&lt;</span>
	</c:if>
	
	<span>
		<input id="page" style="width:30px;" name="page" type="text" value="${currentPage}"/>&nbsp;<spring:message code="common.from" />&nbsp;${pagesCount}
	</span>
	
	<c:if test="${currentPage<pagesCount+0}">
		<span class="page" page="${currentPage+1}">&gt;</span>
	</c:if>
	<c:if test="${currentPage<pagesCount-1}">
		<span class="page" page="${pagesCount}">&gt;&gt;</span>
	</c:if>

	<c:if test="${listSize>0}">&nbsp;<c:if test="${not showall}">(<spring:message code="list.sizelabel"/>:&nbsp;${listSize})</c:if></c:if>
</div>
