<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eba.dao.NewBookDao" %>
<%@ page import="java.util.List" %>
<%@ page import="eba.model.BookDtls" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Noteworthy Reads</title>
<%@include file="all_component/allCss.jsp" %>
<style>
	.crd-ho:hover{
	background-color: #c0c2c4;
	}
</style>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<div class="container" style="background-color: #e1e4e8">
		<h3 class="text center">Noteworthy Reads</h3>
		<div class="row p-3"><%
			NewBookDao newbookdao = new NewBookDao();
			List<BookDtls> list=newbookdao.getAllNoteworthy();
			for(BookDtls book:list)
			{%>
			<div class="col-md-3">
				<div class="card crd-ho mt-3">
					<div class="card-body text-center">
						<img alt="" src="Book/<%=book.getPhotoName()%>" style="height: 200px;width: 150px" class="img-thumblin">
						<p><%=book.getBookname() %></p>
						<p><%=book.getAuthor() %></p>
						<p>Catagories:<%=book.getBookCatagory() %></p>
						<div class="row text-center" >
							<div class="col d-flex justify-content-center align-items-center gap-2">
								<a href="" class="btn btn-danger btn-sm"><i class="fa-solid fa-cart-shopping"></i>Add to Cart</a>
								<a href="view_details.jsp" class="btn btn-success btn-sm"><i class="fa-solid fa-circle-info"></i>View Details</a>
								<a href="" class="btn btn-danger btn-sm"><i class="fa-solid fa-indian-rupee-sign"></i><%=book.getPrice() %></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%}
			%>
		</div>
	</div>
</body>
</html>