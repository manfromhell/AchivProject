<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<h2>
					<spring:message code="label.schedule" />
				</h2>
				<form:form method="post" action="events/add" commandName="event">
					<table>
						<tr>
							<td><form:label path="title">
									<spring:message code="label.selectgroup" />
								</form:label></td>
							<td><form:input path="title" /></td>
						</tr>
					</table>
					<table>
						<tr>
							<td><spring:message code="label.selectday" /></td>
							<td><form:checkbox path="day" value="Monday" />Monday</td>
							<td><form:checkbox path="day" value="Thuesday" />Thuesday</td>
							<td><form:checkbox path="day" value="Wednesday" />Wednesday</td>
							<td><form:checkbox path="day" value="Thursday" />Thursday</td>
							<td><form:checkbox path="day" value="Friday" />Friday</td>
						</tr>
					</table>
					<tr>
						<td><spring:message code="label.selecttime" /></td>
						<form:select path="startTime">
							<form:option value="8:00">8:00</form:option>
							<form:option value="9:00">9:00</form:option>
							<form:option value="10:00">10:00</form:option>
							<form:option value="11:00">11:00</form:option>
							<form:option value="12:00">12:00</form:option>
							<form:option value="13:00">13:00</form:option>
							<form:option value="14:00">14:00</form:option>
							<form:option value="15:00">15:00</form:option>
							<form:option value="16:00">16:00</form:option>
							<form:option value="17:00">17:00</form:option>
						</form:select>
						<td><form:select path="endTime">
								<form:option value="9:00">9:00</form:option>
								<form:option value="10:00">10:00</form:option>
								<form:option value="11:00">11:00</form:option>
								<form:option value="12:00">12:00</form:option>
								<form:option value="13:00">13:00</form:option>
								<form:option value="14:00">14:00</form:option>
								<form:option value="15:00">15:00</form:option>
								<form:option value="16:00">16:00</form:option>
								<form:option value="17:00">17:00</form:option>
								<form:option value="18:00">17:00</form:option>
							</form:select>
					</tr>
					</table>
					<input type="submit" name="Submit" value="Add event">
					<a href="event/parsecsv"><spring:message code="label.parsefile" /></a>
			</security:authorize>

			<c:if test="${!empty eventList}">
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th><spring:message code="label.schedule" /></th>
						<th>&nbsp;</th>
					</tr>
					<tr>
						<TH align="center" valign="middle" width="100">Day</TH>
						<TH align="center" valign="middle">Start time</TH>
						<TH align="center" valign="middle">End time</TH>
						<TH align="center" valign="middle">Group</TH>
						<TH align="center" valign="middle">Action</TH>

					</tr>
					<c:forEach items="${eventList}" var="event">
						<tr>
							<td>${event.day}</td>
							<td>${event.startTime}</td>
							<td>${event.endTime}</td>
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<td>${event.title}</td>
								<td><a href="event/delete/${event.id}"> <spring:message
											code="label.delete" /></a></td>
							</security:authorize>
						</tr>
					</c:forEach>
				</table>
				<a href="parsecsv"><spring:message code="label.parsefile" /></a>
			</c:if>

			</form:form>
			<p>
			<p>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>