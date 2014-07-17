<%@ include file="../../template/default/taglib.jsp"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<form:form method="POST" autocomplete="off" action="create"
			modelAttribute="user" class="form-horizontal"
			style="margin-left: auto; margin-right: auto; width: 30%;">
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<h2 align="center"><spring:message code="label.signup" /></h2>
					<label><spring:message code="label.login" /></label>
					<c:if test="${userExistParameter == 'login'}">
						<p style="color: red">
							<spring:message code="label.userLoginExist" />
						</p>
					</c:if>
					<form:errors path="login" style="color: red" />
					<form:input type="text" title="You login" path="login"
						class="form-control" autocomplete="off" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<label><spring:message code="label.firstname" /></label>
					<form:input type="text" title="You first name" path="firstName"
						class="form-control" autocomplete="off" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<label><spring:message code="label.lastname" /></label>
					<form:input type="text" title="You last name" path="lastName"
						class="form-control" autocomplete="off" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<label><spring:message code="label.password" /></label>
					<form:errors path="password" style="color: red" />
					<form:input type="password" title="You password" path="password"
						class="form-control" autocomplete="off" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<label><spring:message code="label.confirmPassword" /></label>
					<c:if test="${confirmPasswordFail == true	}">
						<p style="color: red">
							<spring:message code="label.confirmPasswordFail" />
						</p>
					</c:if>
					<form:input type="password" title="You password"
						path="confirmPassword" class="form-control" autocomplete="off" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<label><spring:message code="label.email" /></label>
					<c:if test="${userEixtParameter == 'email'}">
						<p style="color: red">
							<spring:message code="label.userEmailExist" />
						</p>
					</c:if>
					<form:errors path="email" style="color: red" />
					<form:input type="text" title="E-mail" path="email"
						class="form-control" autocomplete="off" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<button type="submit" class="btn btn-lg btn-primary btn-block">
						<spring:message code="label.signup" />
					</button>
				</div>
			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>