<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
	
	<!-- css files -->
    <link href="css2/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="css2/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="css2/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext" rel="stylesheet">

	<!-- //google fonts -->
	
</head>
<body>
<%
	//進行session驗證。
	Object obj = session.getAttribute("teacherId");
	if(obj == null){
		//沒有登入，重定向到登入頁面
		response.sendRedirect("login.jsp");
		//沒有必須向下執行
		return;
	}
	Integer teacherId = (Integer) obj;
	%>
<!-- //header -->
<header>
	<div class="container">
		<!-- top header -->
		<div class="row top_header pt-3">
			<div class="col-lg-3 offset-lg-7 col-md-5 offset-md-3 col-sm-6 col-7 offset-sm-2 top-grid">
				<span class="fa ml-3 fa-envelope-open-o"></span>
				<p class=""> <a href="daycare@csye6200.com">daycare@csye6200.com</a> <span class="block">Contact Support</span> </p>
			</div>
			<div class="col-lg-2 col-md-4 col-sm-4 col-5 top-grid pl-0">
				<span class="fa ml-3 fa-phone"></span>
				<p class=""> +1 206 307 8888 <span class="block">24/7 Helpline</span> </p>
			</div>
		</div>
		<!-- top header -->
		<!-- nav -->
		<nav class="pt-2">
			<div id="logo">
				<h1> <a href="index.html"><span class="fa fa-ship"></span> DayCare</a></h1>
			</div>
			<label for="drop" class="toggle">Menu</label>
			<input type="checkbox" id="drop" />
			<ul class="menu mt-md-2 ml-auto">
				<li class="mr-lg-4 mr-2 active"><a href="index.html">Home</a></li>
				<li class="mr-lg-4 mr-2"><a href="about.html">About Us</a></li>
			</ul>
		</nav>
		<!-- //nav -->
	</div>
</header>
<!-- //header -->
		
<!-- banner -->
<section class="banner position-relative" id="home">
	<div class="container">
		<div class="banner-text">
			<div class="slider-info">
				<div class="agileinfo-logo mt-lg-5">
					<h2>DayCare <br> Center</h2>
					<a href="contact.html">Contact Us</a>
				</div>
			</div>
		</div>
		<div class="choose text-center position-absolute d-lg-flex">
			<div class="choose-icon">
				<span class="fa fa-ship" aria-hidden="true"></span>
				<div class=" choose-grid">
					<h3 class="mt-4"><a href="<%=request.getContextPath()%>/studentList.do?teacherId=<%=teacherId%>" target="view_window">Student Info</a></h3>
					<p class="">Students Information</p>
				</div>
			</div>
			<div class="choose-icon">
				<span class="fa fa-truck" aria-hidden="true"></span>
				<div class="choose-grid">
					<h3 class="mt-4"><a href="<%=request.getContextPath()%>/teacherList.do" target="view_window">Teacher Info</a></h3>
					<p class="">Teachers Information</p>
				</div>
			</div>
			<div class="choose-icon">
				<span class="fa fa-ship" aria-hidden="true"></span>
				<div class="choose-grid">
					<h3 class="mt-4"><a href="<%=request.getContextPath()%>/immuStudentList.do?teacherId=<%=teacherId%>" target="view_window">Vaccine Info</a></h3>
					<p class="">Students' Vaccine</p>
				</div>
			</div>
			<div class="choose-icon">
				<span class="fa fa-plane" aria-hidden="true"></span>
				<div class="choose-grid">
					<h3 class="mt-4"><a href="<%=request.getContextPath()%>/NewAddStudent.jsp" target="view_window">Register Info</a></h3>
					<p class="">Registered Students</p>
				</div>
			</div>
			<div class="choose-icon mr-0">
				<span class="fa fa-truck" aria-hidden="true"></span>
				<div class="choose-grid">
					<h3 class="mt-4"><a href="index.do" target="view_window">HOME</a></h3>
					<p class="">Our Story</p>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</section>
<div class="clearfix"></div>
<!-- //banner -->

<!-- about -->
<section class="about py-5" id="how">
	<div class="container py-lg-5">
		<div class="row about-grids">
			<div class="col-lg-6 about-left">
				<img src="img/img3.jpg" alt="" class="img-fluid"/>
			</div>
			<div class="col-lg-6 grid1 mt-lg-0 mt-4 pl-lg-5">
				<h3 class="my-lg-4 mb-2">Take Care Your Children Everytime</h3>
				<p class="">Our DayCare Center focus on taking care of the children from 6 month to 60 month.</p>
				<p class="mt-3">In our system, you can find classes and teachers information. You also can know the basic
				 information about every students. And we keep renew register and vaccine infomation every year, those who
				 are not vaccinated at the appropriate age will be reminded.</p>
			</div>
		</div>
	</div>
</section>
<!-- //about -->


<!-- footer-top -->
<section class="footer-top py-5">
	<div class="container">
		<div class="row footer-top-grid">
			<div class="col-sm-6">
				<h3>Contact Us</h3>
				<p>Call us, we are 24/7 Helpline</p>
			</div>
			<div class="col-sm-6 text-sm-right mt-sm-0 mt-3">
				<h3><span class="fa fa-phone" aria-hidden="true"></span> +1 206 307 8888</h3>
			</div>
		</div>
	</div>
</section>
<!-- //footer-top -->

</body>
</html>