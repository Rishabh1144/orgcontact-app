<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>OrgContact - Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="<c:url value="/res/css/register.css"/>" rel="stylesheet"/>
</head>

<body>

<!-- Header -->

<nav class="navbar navbar-expand-lg navbar-dark">
<div class="container">

<a class="navbar-brand" href="#">
Org<span>Contact</span>
</a>

<div>
<a href="login" class="btn btn-outline-light btn-sm">Login</a>
</div>

</div>
</nav>

<!-- Main Content -->

<div class="container main">

<div class="row align-items-center w-100">

<!-- Welcome Section -->

<div class="col-md-6 text-white">

<h1 class="hero-title mb-3">
Create Your Organization
</h1>

<p class="hero-text mb-4">
Register your organization on OrgContact and start managing
your team members and contacts from one simple dashboard.
</p>

<ul class="hero-text">
<li>✔ Create organization workspace</li>
<li>✔ Manage team contacts easily</li>
<li>✔ Access your dashboard securely</li>
</ul>

</div>

<!-- Register Form -->

<div class="col-md-6">

<c:if test="${not empty error}">
	<div class="alert alert-danger">
		${error}
	</div>
</c:if>

<div class="register-card">

<h3 class="text-center mb-4" style="color:#2D9FFF;">Register Organization</h3>

<form action="register" method="post">

<div class="mb-3">
<label class="form-label">Organization Name</label>
<input type="text" name="name" class="form-control" placeholder="Enter organization name">
</div>

<div class="mb-3">
<label class="form-label">Email</label>
<input type="email" name="email" class="form-control" placeholder="Enter email address" required>
</div>

<div class="mb-4">
<label class="form-label">Password</label>
<input type="password" name="password" class="form-control" placeholder="Enter password" required>
</div>

<div class="d-grid">
<button class="btn btn-register">Register</button>
</div>

</form>

<p class="text-center mt-3">
Already registered? <a href="login">Login</a>
</p>

</div>

</div>

</div>

</div>

<!-- Footer -->

<footer>
© 2026 OrgContact • Manage organization contacts easily
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
