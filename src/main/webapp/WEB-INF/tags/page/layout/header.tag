<%@ include file="/jsp/taglibs.jsp"%>

<%@tag import="org.springframework.security.core.context.SecurityContextHolder"%><tr>
	<td>
		&nbsp;
	</td>
	<td width="95%" id="mainHeaderTD">
		<h3>
			<layout:title />
		</h3>
		<div id="userinfo">
			<spring:message code="site.commons.user" />:&nbsp;<%=SecurityContextHolder.getContext().getAuthentication().getName() %>
			<%=SecurityContextHolder.getContext().getAuthentication().getAuthorities() %>
		</div>
	</td>
</tr>
