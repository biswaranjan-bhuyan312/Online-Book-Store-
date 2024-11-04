<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eba.dao.AddBookDao" %>
<%@ page import="eba.model.BookDtls" %>
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
	<div class="container">
		<div class="row">
			<div class="col-md-4  offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Books</h4>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AddBookDao dao = new AddBookDao();
						BookDtls b = dao.getBookById(id);
						%>
						
						
						<form action="../edit_Books" method="post">
							<input type="hidden" name="id" value="<%=b.getBookId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Book Name</label> 
								<input type="text" class="form-control" name="bname" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%=b.getBookname()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Author Name</label>
								<input type="text" class="form-control" id="exampleInputPassword1" name="author" value="<%=b.getAuthor()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Price</label>
								<input type="number" class="form-control" id="exampleInputPassword1" name="price" value="<%=b.getPrice()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Book Status</label>
								<select id="inputstate" name="bstatus" class="form-control">
								<%
								if("Active".equals(b.getStatus())){
								%>
								<option value="Active">Active</option>
								<option value="inactive">inactive</option>
								<% 	
								}else{
								%>
								<option value="inactive">inactive</option>
								<option value="Active">Active</option>
								<% 
								}
								%>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>