<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eba.dao.NewBookDao" %>
<%@ page import="java.util.List" %>
<%@ page import="eba.model.BookDtls" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Details</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body style="background-color: #f0f1f2">
<%@include file="all_component/navbar.jsp" %>
<%
 int bid = Integer.parseInt(request.getParameter("bid")); 
 NewBookDao addBookdao = new  NewBookDao();
 BookDtls book = addBookdao.getBookById(bid);


%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="book/<%=book.getPhotoName() %>" alt="Book here" style="height:200px;width:150px"><br>
				<h4 class="mt-2">Book Name:<span class="text-primary"><%=book.getBookname() %></span></h4>
				<h4>Author :<span class="text-primary"><%=book.getAuthor() %></span></h4>
				<h4>Catagory : <span class="text-primary"><%=book.getBookCatagory() %></span></h4>
			</div>
			<div class="col-md-6 text-center bg-white">
				<h2><%=book.getBookname() %></h2>
				<div class="d-flex justify-content-center align-items-center gap-3">
					<div class="col-md-4  text-danger text-center p-3">
						<i class="fa-solid fa-sack-dollar fa-2x"></i>
						<p>Cash on Delivery</p>
					</div>
					<div class="col-md-4  text-danger text-center p-3">
						<i class="fa-solid fa-rotate-left fa-2x"></i>
						<p>Return Vailable</p>
					</div>
					<div class="col-md-4  text-danger text-center p-3">
						<i class="fa-solid fa-truck fa-2x"></i>
						<p>Free Delivery</p>
					</div>
				</div>
				<div class="text-center p-3">
					<a href="" class="btn btn-primary bg-primary">Add to cart</a>
					<a href="" class="btn btn-primary bg-danger"><i class="fa-solid fa-indian-rupee-sign"></i><%=book.getPrice() %></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>