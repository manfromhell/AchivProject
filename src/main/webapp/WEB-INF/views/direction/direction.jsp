<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="newdirection"><spring:message code="label.add"/></a>
		</security:authorize>
			<c:if test="${!empty directionList}">
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th><spring:message code="label.directions" /></th>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						</security:authorize>
					</tr>
					<c:forEach items="${directionList}" var="direction">
						<tr>
							<td>${direction.name}</td>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<td><a href="direction/edit/${direction.id}"><spring:message
										code="label.edit" /></a></td>
							<td><a href="direction/delete/${direction.id}"> <spring:message
										code="label.delete" /></a></td>
							</security:authorize>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>