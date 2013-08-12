<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="noname" required="false" %>

<c:if test="${noname==false}">
<div class="region region_${id}" region="${id}">${title}</div>
</c:if>
<div class="chooser region_${id}_div" style="display:none;">
	<jsp:doBody />
</div>