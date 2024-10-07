<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EBook : Register</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="all_component/navbar.jsp" %>
<div class="container p-2">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
					<h4 class="text-center">Registration</h4>
					<c:if test="${not empty Succmsg }">
						<p class="text-center text-success ">${Succmsg } </p>
						<c:remove var="Succmsg" scope="session"/>
					</c:if>
					<c:if test="${not empty failedmsg }">
						<p class="text-center text-danger ">${failedmsg } </p>
						<c:remove var="failedmsg" scope="session"/>
					</c:if>
						<form action="register" method="post">
							<div class="mb-3">
								<label for="exampleInputName" class="form-label">Enter Full Name</label>
								 <input type="text" class="form-control"id="exampleInputName" aria-describedby="nameHelp" required="required" name="name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email address</label>
								 <input type="email" class="form-control"id="exampleInputEmail1" aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="mb-3">
								<label for="exampleInputNumber" class="form-label">Phone No</label>
								 <input type="Number" class="form-control"id="exampleInputNumber" aria-describedby="numberHelp" required="required" name="phn_no">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"id="exampleInputPassword1" required="required" name="password">
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"id="exampleCheck1" name="check"> <label class="form-check-label" for="exampleCheck1" >Check me out</label>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</form>
					</div>
			</div>
		</div>
	</div>
</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>