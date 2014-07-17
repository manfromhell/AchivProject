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
		<security:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
			<a href="newgroup"><spring:message code="label.add"/></a>
		</security:authorize>
			<c:if test="${!empty groupList}">
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th><spring:message code="label.groups" /></th>
						<th><spring:message code="label.direction" /></th>
						<th><spring:message code="label.start" /></th>
						<th><spring:message code="label.finish" /></th>
						<security:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_USER')">
						<th>&nbsp;</th>
						</security:authorize>
					</tr>
					<c:forEach items="${groupList}" var="group">
						<tr>
							<td>${group.groupName}</td>
							<td>${group.direction.name}</td>
							<td>${group.start}</td>
							<td>${group.end}</td>
							<security:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
							<td><a href="group/edit/${group.id}"><spring:message
										code="label.edit" /></a></td>
							<td><a href="group/delete/${group.id}"> <spring:message
										code="label.delete" /></a></td>
							</security:authorize>
							<security:authorize access="hasRole('ROLE_USER')">
							<td><a href="group/apply/${group.id}"><spring:message
										code="label.apply" /></a></td>
							</security:authorize>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>