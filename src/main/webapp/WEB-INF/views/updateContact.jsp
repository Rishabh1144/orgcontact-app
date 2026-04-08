<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>OrgContact Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="<c:url value="/res/css/dashboard.css"/>" rel="stylesheet">

</head>

<body>

<!-- Navbar -->

<nav class="navbar navbar-dark">
<div class="container-fluid">

<!-- Left side: Dashboard Title -->
<span class="navbar-brand mb-0 h1">
	OrgContact Dashboard
</span>

<!-- Right side: Organization Name + Logout -->
<div class="d-flex align-items-center">
	<span class="text-white me-3">
		Welcome, <strong>TCS</strong>
	</span>
	<a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
</div>

</div>
</nav>

<div class="container-fluid">
<div class="row">

<!-- Sidebar -->

<div class="col-md-2 sidebar">

<a href="#">Dashboard</a> <a href="#addContact">Add Contact</a> <a href="#contactTable">All Contacts</a>

</div>

<!-- Main Content -->

<div class="col-md-10 main">

<h3 class="mb-4">Organization Contacts</h3>

<!-- Add Contact Form -->

<div class="card mb-4" id="addContact">

<div class="card-body">

<h5>Update Contact</h5>

<form action="<c:url value="/updateContact"/>" method="post">

<div class="row">

<input type="hidden" name="id" value="${contact.id }" />

<div class="col-md-4 mb-3">
<input type="text" name="name" class="form-control" value="${contact.name }" placeholder="Name" required>
</div>

<div class="col-md-4 mb-3">
<input type="email" name="email" class="form-control" value="${contact.email }" placeholder="Email">
</div>

<div class="col-md-4 mb-3">
<input type="text" name="phone" class="form-control" value="${contact.phone }" placeholder="Phone">
</div>

<div class="col-md-4 mb-3">
<input type="text" name="designation" class="form-control" value="${contact.designation }" placeholder="Designation">
</div>

<div class="col-md-4 mb-3">
<input type="text" name="deptName" class="form-control" value="${contact.deptName }" placeholder="Department">
</div>

</div>

<button class="btn btn-danger">
Update Contact
</button>

<c:if test="${not empty error}">
	<span class="text-danger ms-3">${error}</span>
</c:if>

</form>

</div>

</div>

<!-- Contacts Table -->

</div>

</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
