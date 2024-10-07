<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin : home</title>
<%@include file="allCss.jsp" %>

<style type="text/css">
a{
text-decoration :none;
color :black;
}
a:hover{
text-decoration :none;
color :black;
}
/* Ensure the body takes up the full height */
 html, body {
     height: 100%;
     margin: 0;
     display: flex;
     flex-direction: column;
 }
 
 /* The main content should grow to take up available space */
 .container {
     flex-grow: 1;
 }

 /* Footer should stay at the bottom */
 footer {
     margin-top: auto;
 }
/* Optionally, you can add a hover effect if needed */
        a:hover {
            text-decoration: underline;
        }
</style>
</head>
<body>
<%@include file="navbar.jsp" %>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
			<a href="add_books.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-regular fa-square-plus fa-3x text-primary"></i><br>
						<h4>Add Books</h4>
						------------------
					</div>
				</div>
			</a>
			</div>
			<div class="col-md-3">
			<a href="all_books.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-book-open fa-3x text-danger"></i><br>
						<h4>All Books</h4>
						------------------
					</div>
				</div>
			</a>
			</div>
			<div class="col-md-3">
			<a href="orders.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-box fa-3x text-warning"></i><br>
						<h4>Orders</h4>
						------------------
					</div>
				</div>
			</a>
			</div>
			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i><br>
						<h4>Log out</h4>
						------------------
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>