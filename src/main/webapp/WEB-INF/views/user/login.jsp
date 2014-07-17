
<%@ include file="../../template/default/taglib.jsp"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">


		<form:form class="form-horizontal" role="form"
			action='softserveinc/j_spring_security_check' method='POST'
			style="margin-left: auto; margin-right: auto; width: 30%;">
			<div class="form-group">
				<div class=" col-sm-offset-1 col-sm-10">
					<h2 class="form-signin-heading">Please sign in</h2>
					<c:if test="${error}">
						<p style="color: red">Login or password is incorrect.</p>
					</c:if>
					<input type="text" class="form-control" id="inputEmail3"
						placeholder="Login" name='j_username' />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<input type="password" class="form-control" name='j_password'
						placeholder="Password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<button type="submit" class="btn btn-lg btn-primary btn-block">Sign
						in</button>
				</div>
			</div>

		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>