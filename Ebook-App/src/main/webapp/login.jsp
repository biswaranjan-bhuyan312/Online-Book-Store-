<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EBook: Login</title>
<%@include file="all_component/allCss.jsp" %>
<style>
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
        /* Remove underline from links */
        a {
            text-decoration: none;
        }

        /* Optionally, you can add a hover effect if needed */
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="all_component/navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Login</h3>
						<form>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email address</label>
								 <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" id="exampleInputPassword1" required="required">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button><br>
								<a href="register.jsp">Create Account</a>
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