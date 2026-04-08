<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>OrgContact - Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="res/css/login.css" rel="stylesheet">

</head>

<body>

<!-- Header -->

<nav class="navbar navbar-expand-lg navbar-dark">
<div class="container">

<a class="navbar-brand" href="#">
Org<span>Contact</span>
</a>

<div>
<a href="register.html" class="btn btn-outline-light btn-sm">Register</a>
</div>

</div>
</nav>

<!-- Main Content -->

<div class="container main">

<div class="row justify-content-center w-100">

<div class="col-md-5">

<div class="login-card">

<h3 class="text-center mb-4" style="color:#2D9FFF;">Organization Login</h3>

<form action="login" method="post">

<div class="mb-3">
<label class="form-label">Email</label>
<input type="email" name="email" class="form-control" placeholder="Enter email" required>
</div>

<div class="mb-4">
<label class="form-label">Password</label>
<input type="password" name="password" class="form-control" placeholder="Enter password" required>
</div>

<div class="d-grid">
<button class="btn btn-login">Login</button>
</div>

</form>

<p class="text-center mt-3">
Don't have an organization? <a href="register.html">Register</a>
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
