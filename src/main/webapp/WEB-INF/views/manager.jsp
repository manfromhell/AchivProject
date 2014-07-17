<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
			<h2>
				<spring:message code="label.managers" />
			</h2>
			<form:form method="post" action="managers/add" commandName="manager">
			</form:form>
			<h3>
				<spring:message code="label.users" />
			</h3>
			<c:if test="${!empty userList}">
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th><spring:message code="label.firstname" />, <spring:message
								code="label.lastname" /></th>
						<th><spring:message code="label.login" /></th>
						<th><spring:message code="label.email" /></th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td><input type="checkbox" name="name" value="name">${user.lastName},${user.firstName}</td>
							<td>${user.login}</td>
							<td>${user.email}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
		<div>
			some button
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>