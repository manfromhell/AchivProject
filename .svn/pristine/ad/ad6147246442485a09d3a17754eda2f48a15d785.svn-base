<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<style>
<%@include file='/WEB-INF/css/form_style.css'%>
</style>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
			<form:form class="form-horizontal" method="post" action="addManager"
				commandName="user"
				style="margin-left: auto; margin-right: auto; width: 10%;">
				<h2>
					<spring:message code="label.addManager" />
				</h2>
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
			</form:form>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>