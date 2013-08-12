<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<page:content>
	<jsp:attribute name="title">
		<spring:message code="section.logs.report" />
	</jsp:attribute>
	<jsp:body>
        <script type="text/javascript">
        $(document).ready(function() {

            $("#lookByDate").click(function() {
                $('#promoListForm').submit();
            });
            $(".calendar").datepicker(
                    { dateFormat: 'dd.mm.yy', changeYear:true, changeMonth:true, yearRange: '2009:2030' });

        });
    </script>
		<form:form id="promoListForm" modelAttribute="parameters" name="parameters" method="post" action="${pageContext.request.contextPath}/logs">

			<div style="padding-bottom: 13px;">
            <table class="dates">

                <tr>
                    <td>
                        <spring:message code="common.calendar.from"/>
                    </td>
                    <td>
                        <form:input path="begin" id="begin" cssClass="calendar"/>
                    </td>
                    <td style="padding-left: 10px">
                        <spring:message code="common.calendar.to"/>
                    </td>
                    <td>
                        <form:input path="end" id="end" cssClass="calendar"/>
                        <input type="button" id="lookByDate" style="cursor: pointer" value="Показать"/>
                    </td>

                </tr>
            </table>

        </div>

            <div style="float:left; padding-bottom: 13px;">
            <ctrl:simpleListControl action="list" id="pageSize">
				<jsp:attribute name="value">${parameters.pageSize}</jsp:attribute>
			</ctrl:simpleListControl>
			<ctrl:pages>
				<jsp:attribute name="action">list?pageSize=${parameters.pageSize}</jsp:attribute>
				<jsp:attribute name="pagesCount">${pagesCount}</jsp:attribute>
				<jsp:attribute name="currentPage">${parameters.page}</jsp:attribute>
				<jsp:attribute name="listSize">${listSize}</jsp:attribute>
			</ctrl:pages>

            <form:hidden path="page"/>
			<form:hidden path="orderby"/>
			<form:hidden path="direction"/>
            </div>

			<table class="stat">
				<thead>
					<tr>
                        <th><spring:message code="section.melodies.list.id" /></th>
                        <th><spring:message code="section.logs.operator" /></th>
                        <th class="sortable" sortField="dateadded"><spring:message code="section.melodies.list.date" /><span class="sortlink"></span></th>
						<th><spring:message code="section.logs.action" /></th>

					</tr>
                    <tr>
                        <th style="padding:0"></th>
                        <th style="padding:0"><form:input id="name" path="name" /></th>
                        <th style="padding:0"></th>
                        <th style="padding:0; width:60%"></th>
                    </tr>

				</thead>
                <c:forEach items="${promolist}" var="list">
					<tr>
						<td>${list.someId}</td>
						<td>${list.operator}</td>
                        <td>${list.dateadded}</td>
                        <td>${list.action}</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
        <script type="text/javascript">
            $(".sortable").click(function(){
				var $this = $(this);
				var field = $this.attr('sortField');
				var order = $this.attr('sortOrder');
				order = (order == null) ? 'asc' : order;
				order = (order == 'desc') ? 'asc' : 'desc';
				$this.attr('sortOrder',order);
				$('.sortedby').removeClass('sortedby');
				$this.addClass('sortedby');
				$('#orderby').val(field);
				$('#direction').val(order);
				$('#searchButton').click();
			});


            $(".page").click(function(){
				var $this = $(this);
				var page = $this.attr('page');
				$('#page').val(page);
				$('#searchButton').click();
			});

            $('.sortlink').hide();

			var field = $('#orderby').val();
			var order = $('#direction').val();
			$.each($(".sortable"), function(index, value){
				var $this = $(this);
				var attr = $this.attr('sortField');

				if (attr == field) {
					$this.addClass('sortedby');
					$this.attr('sortOrder',order);
					$this.children('.sortlink').html(order=='desc'?'\\/':'/\\');
					$this.children('.sortlink').show();
				}
			});
        </script>
	</jsp:body>
</page:content>