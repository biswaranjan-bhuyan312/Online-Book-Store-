<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> admin : add_book</title>
<%@include file="allCss.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="navbar.jsp" %>
<c:if test="${empty userobj}">
	<c:redirect url="../login.jsp"></c:redirect>
</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-4  offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Add Books</h4>
						<c:if test="${not empty Succmsg }">
							<p class="text-center text-success ">${Succmsg }</p>
							<c:remove var="Succmsg" scope="session" />
						</c:if>
						<c:if test="${not empty failedmsg }">
							<p class="text-center text-danger ">${failedmsg }</p>
							<c:remove var="failedmsg" scope="session" />
						</c:if>
						<form action="../add_Books" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Book Name</label> 
								<input type="text" class="form-control" name="bname" id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Author Name</label>
								<input type="text" class="form-control" id="exampleInputPassword1" name="author">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Price</label>
								<input type="number" class="form-control" id="exampleInputPassword1" name="price">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Book Catagories</label>
								<select id="inputstate" name="btype" class="form-control">
								<option selected>---Select---</option>
								<option value="new">New Book</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Book Status</label>
								<select id="inputstate" name="bstatus" class="form-control">
								<option selected>---Select---</option>
								<option value="Active">Active</option>
								<option value="inactive">inactive</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleformcontrolfile1">Upload Photo</label>
								<input type="file" class="form-control-file" id="exampleformcontrolfile1" name="bimg">
							</div>
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
