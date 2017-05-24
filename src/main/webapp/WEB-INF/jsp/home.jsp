<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>List of Universities</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link rel="shortcut icon" href="#" />

<!-- global css -->
<link type="text/css" rel="stylesheet" href="css/app.css" />
<!-- end of global css -->
<!--page level css -->
<link rel="stylesheet" type="text/css"
	href="vendors/datatables/css/dataTables.bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="vendors/datatablesmark.js/css/datatables.mark.min.css" />
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" href="css/custom_css/skins/skin-default.css"
	type="text/css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="css/custom_css/responsive_datatables.css">
<!--end of page level css-->

<!--page level css -->
<link href="vendors/clockface/css/clockface.css" rel="stylesheet"
	type="text/css" />
<link href="vendors/colorpicker/css/bootstrap-colorpicker.min.css"
	rel="stylesheet" type="text/css" />
<link href="vendors/datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="vendors/bootstrap-touchspin/css/jquery.bootstrap-touchspin.css"
	rel="stylesheet" type="text/css" />
<link href="vendors/bootstrap-multiselect/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
<link href="vendors/clockpicker/css/bootstrap-clockpicker.min.css"
	rel="stylesheet" type="text/css" />
<link href="vendors/bootstrap-switch/css/bootstrap-switch.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/custom.css">
<!-- <link rel="stylesheet" href="css/custom_css/skins/skin-default.css" type="text/css" id="skin"/>-->
<link rel="stylesheet" type="text/css" href="css/pickers.css">
<!--end of page level css-->

<!--buttons-->
<link href="vendors/hover/css/hover-min.css" rel="stylesheet">
<link rel="stylesheet"
	href="vendors/laddabootstrap/css/ladda-themeless.min.css">
<link href="css/buttons_sass.css" rel="stylesheet">
<link href="css/advbuttons.css" rel="stylesheet">
</head>

<body class="skin-default">
	<div class="preloader">
		<div class="loader_img">
			<img src="img/loader.gif" alt="loading..." height="64" width="64">
		</div>
	</div>
	<!-- header logo: style can be found in header-->
	<header class="header">
		<nav class="navbar navbar-static-top" role="navigation">
			<a href="#" class="logo"> <!-- Add the class icon to your logo image or logo icon to add the margining -->
				<!--<img src="img/logo.png" alt="logo"/>-->
				<h2 style="color: #fff; margin: 10px 0px 0px 0px; font-size: 28px;">
					Course Portal</h2>
			</a>
			<!-- Header Navbar: style can be found in header-->
			<!-- Sidebar toggle button-->
			<div>
				<a href="#" class="navbar-btn sidebar-toggle"
					data-toggle="offcanvas" role="button"> <i
					class="fa fa-fw ti-menu"></i>
				</a>
			</div>

		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<!-- sidebar: style can be found in sidebar-->
			<section class="sidebar">
				<div id="menu" role="navigation">
					<div class="nav_profile">
						<div class="media profile-left">
							<a class="pull-left profile-thumb" href="#"> <img
								src="img/authors/avatar1.jpg" class="img-circle"
								alt="User Image">
							</a>
							<div class="content-profile">
								<h4 class="media-heading">Home Page</h4>
								<ul class="icon-list">
									<!-- <li><a href="logout"> <i
											class="fa fa-fw ti-shift-right"></i>
									</a></li> -->
								</ul>
							</div>
						</div>
					</div>
					<jsp:include page="menu.jsp"></jsp:include>
					<!-- / .navigation -->
				</div>
				<!-- menu -->
			</section>
			<!-- /.sidebar -->
		</aside>
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>List of Universities</h1>
				<!-- <ol class="breadcrumb">
					<li><a href="#"> <i class="fa fa-fw ti-home"></i> Home
					</a></li>
					<li><a href="#"> Admin</a></li>
					<li class="active">Stock Statement</li>
				</ol> -->
			</section>
			<!-- Main content -->
			<section class="content">
				<form:form action="stock_statement" id="authentication"
					method="post" class="profit" commandName="profit">
					<!--Table-->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel filterable">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="ti-move"></i>Universities
									</h3>
								</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered" id="table2">
											<thead>
												<tr>
													<th></th>
													<th>Country Code</th>
													<th>Name</th>
													<th>country</th>
													<th>domain</th>
													<th>Link</th>
												</tr>
											</thead>
											<tbody>
												<%
													int i = 0;
												%>
												<c:forEach var="university"
													items="${requestScope.universities}">
													<tr>
														<td><%=++i%></td>
														<td>${university.alpha_two_code}</td>
														<td><a href="/">${university.name}</a></td>
														<td>${university.country}</td>
														<td>${university.domain}</td>
														<td><a href="${university.web_page}" target="_blank">${university.web_page}</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--Table End -->

					<div class="background-overlay"></div>
				</form:form>
			</section>
		</aside>
	</div>
	<!-- wrapper-->
	<!-- global js -->
	<script src="js/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/g/bootstrap@3.3.7,bootstrap.switch@3.3.2,jquery.nicescroll@3.6.0"></script>
	<script src="js/app.js" type="text/javascript"></script>
	<!-- end of global js -->
	<!-- begning of page level js -->
	<script type="text/javascript"
		src="vendors/datatables/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="vendors/datatables/js/dataTables.bootstrap.js"></script>
	<script src="vendors/mark.js/jquery.mark.js" charset="UTF-8"></script>
	<script src="vendors/datatablesmark.js/js/datatables.mark.min.js"
		charset="UTF-8"></script>
	<script src="js/custom_js/responsive_datatables.js"
		type="text/javascript"></script>
	<!-- end of page level js -->
	<script src="js/custom_js/pickers.js" type="text/javascript"></script>


	<script src="vendors/moment/js/moment.min.js" type="text/javascript"></script>
	<script src="vendors/colorpicker/js/bootstrap-colorpicker.min.js"
		type="text/javascript"></script>
	<script src="vendors/clockpicker/js/bootstrap-clockpicker.min.js"
		type="text/javascript"></script>
	<script src="vendors/datetimepicker/js/bootstrap-datetimepicker.min.js"
		type="text/javascript"></script>
	<script src="vendors/bootstrap-multiselect/js/bootstrap-multiselect.js"
		type="text/javascript"></script>
	<script src="vendors/clockface/js/clockface.js" type="text/javascript"></script>
	<script
		src="vendors/bootstrap-touchspin/js/jquery.bootstrap-touchspin.js"
		type="text/javascript"></script>
	<script src="vendors/bootstrap-switch/js/bootstrap-switch.js"
		type="text/javascript"></script>
	<script src="vendors/toolbar/js/jquery.toolbar.min.js"></script>



	<!-- begining of page level js -->
	<script type="text/javascript" src="vendors/Buttons/js/buttons.js"></script>
	<script type="text/javascript"
		src="vendors/laddabootstrap/js/spin.min.js"></script>
	<script type="text/javascript"
		src="vendors/laddabootstrap/js/ladda.min.js"></script>
	<script type="text/javascript" src="js/custom_js/button_main.js"></script>
	<!--end of page level js-->
</body>


</html>
