<%@tag import="java.util.ArrayList"%>
<%@ include file="/jsp/taglibs.jsp"%>

<%@ attribute name="days" %>
<%@ attribute name="startDay" %>
<%@ attribute name="endDay" %>

<%@ attribute name="startMonth" %>
<%@ attribute name="endMonth" %>
<%@ attribute name="startYear" %>
<%@ attribute name="endYear" %>

<%@ attribute name="currentYear" %>
<div style="padding: 10px 0;">
	<spring:message code="periods.start"></spring:message>:&nbsp;
	<c:if test="${days}">
		<select name="dayFrom" id="dayFrom" class="dater">
			<c:forEach begin="1" end="31" var="day">
				<c:if test="${startDay == day}">
					<option value="${day}" selected="selected">
						${day}
					</option>
				</c:if>
				<c:if test="${startDay != day}">
					<option value="${day}">
						${day}
					</option>
				</c:if>
			</c:forEach>
		</select>
	</c:if>

	<select name="monthFrom" id="monthFrom" class="dater">
		<c:forEach begin="1" end="12" var="month">
			<c:if test="${startMonth == month}">
				<option value="${month}" selected="selected">
					<spring:message>
						<jsp:attribute name="code">periods.month${month}</jsp:attribute>
					</spring:message>
				</option>
			</c:if>
			<c:if test="${startMonth != month}">
				<option value="${month}">
					<spring:message>
						<jsp:attribute name="code">periods.month${month}</jsp:attribute>
					</spring:message>
				</option>
			</c:if>
		</c:forEach>
	</select>
	<select name="yearFrom" id="yearFrom" class="dater">
		<c:forEach begin="2010" end="${currentYear}" var="year">
			<c:if test="${startYear == year}">
				<option value="${year}" selected="selected">${year}</option>
			</c:if>
			<c:if test="${startYear != year}">
				<option value="${year}">${year}</option>
			</c:if>
		</c:forEach>
	</select>
	
	&nbsp;&nbsp;
	<spring:message code="periods.end"></spring:message>:&nbsp;
	
	<c:if test="${days}">
		<select name="dayTo" id="dayTo" class="dater">
			<c:forEach begin="1" end="31" var="day">
				<c:if test="${endDay == day}">
					<option value="${day}" selected="selected">
						${day}
					</option>
				</c:if>
				<c:if test="${endDay != day}">
					<option value="${day}">
						${day}
					</option>
				</c:if>
			</c:forEach>
		</select>
	</c:if>	
	<select name="monthTo" id="monthTo" class="dater">
		<c:forEach begin="1" end="12" var="month">
			<c:if test="${endMonth == month}">
				<option value="${month}" selected="selected">
					<spring:message>
						<jsp:attribute name="code">periods.month${month}</jsp:attribute>
					</spring:message>
				</option>
			</c:if>
			<c:if test="${endMonth != month}">
				<option value="${month}">
					<spring:message>
						<jsp:attribute name="code">periods.month${month}</jsp:attribute>
					</spring:message>
				</option>
			</c:if>
		</c:forEach>
	</select>
	<select name="yearTo" id="yearTo" class="dater">
		<c:forEach begin="2010" end="${currentYear}" var="year">
			<c:if test="${endYear == year}">
				<option value="${year}" selected="selected">${year}</option>
			</c:if>
			<c:if test="${endYear != year}">
				<option value="${year}">${year}</option>
			</c:if>
		</c:forEach>
	</select>
</div>