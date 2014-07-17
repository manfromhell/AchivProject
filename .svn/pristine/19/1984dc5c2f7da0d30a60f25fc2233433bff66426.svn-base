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
		<spring:message code="label.users" />
	</h2>
	<form:form method="post" action="users/add" commandName="user">
		<table>
			<tr>
				<td><form:label path="firstName">
						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="login">
						<spring:message code="label.login" />
					</form:label></td>
				<td><form:input path="login" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message code="label.password" />
					</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.add"/>" /></td>
			</tr>
		</table>
	</form:form>
	<h3>
		<spring:message code="label.users" />
	</h3>
	<c:if test="${!empty userList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.firstname" /></th>
				<th><spring:message code="label.lastname" /></th>
				<th><spring:message code="label.login" /></th>
				<th><spring:message code="label.password" /></th>
				<th><spring:message code="label.email" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.lastName},${user.firstName}</td>
					<td>${user.login}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>

				</tr>
			</c:forEach>
		</table>
	</c:if>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>