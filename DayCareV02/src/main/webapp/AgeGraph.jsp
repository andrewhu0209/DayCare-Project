<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Age Graph</title>
<meta charset="utf-8">
    <title>Student Age Distribution</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.min.js"></script>
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
				<li class="mr-lg-4 mr-2 active"><a href="index.do">Home</a></li>
				<li class="mr-lg-4 mr-2"><a href="login.do">Log out</a></li>
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
					<a href="index.do">Contact Us</a>
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
				<span class="fa fa-pie-chart" aria-hidden="true"></span>
				<div class="choose-grid">
					<h3 class="mt-4"><a href="ageGraph.do" target="view_window">Graph</a></h3>
					<p class="">Student Age Statistics</p>
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
		
		<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 800px;height:600px; margin: 0 auto 0 auto"></div>
    <script type="text/javascript">
 // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
    	    title : {
    	        text: 'Student Age Distribution',
    	        subtext: '6-60 Month',
    	        x:'center'
    	    },
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },
    	    legend: {
    	        orient: 'vertical',
    	        left: 'left',
    	        data: ['6-12','13-24','25-35','36-47','48-59','60-65']
    	    },
    	    series : [
    	        {
    	            name: '访问来源',
    	            type: 'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[
    	            	/* 人數 */
    	            	
    	            	<%
						int[] ageCount = (int[]) request.getAttribute("ageCount");
					
							
    	            	%>
    	                {value:<%=ageCount[0]%>, name:'6-12'},
    	                {value:<%=ageCount[1]%>, name:'13-24'},
    	                {value:<%=ageCount[2]%>, name:'25-35'},
    	                {value:<%=ageCount[3]%>, name:'36-47'},
    	                {value:<%=ageCount[4]%>, name:'48-59'},
    	                {value:<%=ageCount[5]%>, name:'60-65'}
    	            ],
    	            itemStyle: {
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>	
		
		
		
		
		
		
		
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