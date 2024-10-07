<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eba.dao.AddBookDao" %>
<%@ page import="java.util.List" %>
<%@ page import="eba.model.BookDtls" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin : All Books</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class=" p-5">
<table class="table table-striped">
 <thead class="bg-danger">
    <tr>
      <th scope="col">id</th>
      <th scope="col">image</th>
      <th scope="col">Book name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Catagories</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<%
  		AddBookDao addbookDao = new AddBookDao();
  		List <BookDtls> list = addbookDao.getBook();
  		for(BookDtls book:list){
  		%>
				<tr>
					<th><%=book.getBookId()%></th>
			<td><img src="../book/<%= book.getPhotoName() %>" style="width:50px;height:50px;"></td>
					<td><%=book.getBookname()%></td>
					<td><%=book.getAuthor()%></td>
					<td><%=book.getPrice()%></td>
					<td><%=book.getBookCatagory()%></td>
					<td><%=book.getStatus()%></td>
					<td><a href="#" class="btn btn-sm btn-primary">Edit</a> <a
						href="#" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
  </tbody>
</table>
</div>
<div style="margin-top: 230px">
<%@include file="footer.jsp" %>
</div>
</body>
</html>