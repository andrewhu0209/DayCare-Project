<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<meta name="keywords" content="" />
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
	<link href="css/styleAddStudent.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
</head>
<body>
	<%
	Object obj = session.getAttribute("teacherId");
	if(obj == null){
	response.sendRedirect("login.jsp");
	return;
}else if((Integer)obj!= 0){
response.sendRedirect("index.jsp");
return;
}
%>
<div class="signupform">
	<br>
	<br>
	<p>
		<%	
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
		%>
		<%=sdf.format(date)%> <br />
	</p>

	<h1 style="color:black" ><strong>Daycare Student Date</strong></h1>
	<div class="container">

		<div class="agile_info">
			<div class="w3_info">
				<h2 style="color: black">Create An Account</h2>
				<form action="add.do" method="post">
					<div class="input-group">
						<span><i class="fa fa-user-md" aria-hidden="true"></i></span>
						<input type="text" placeholder="Name" name="name" required>
					</div>
					<div class="input-group">
						<span><i class="fa fa-pagelines" aria-hidden="true"></i></span>
						<input type="text" placeholder="Age" name="age" required>
					</div>
					
					<div class="input-group">
						<span><i class="fa fa-user-plus" aria-hidden="true"></i></span>
						<input type="text" placeholder="Parent's Name" name="parentsName" required>
					</div>
					
					<div class="input-group">
						<span><i class="fa fa-location-arrow" aria-hidden="true"></i></span>
						<input type="text" placeholder="Address" name="address" required>
					</div>
					<div class="input-group">
						<span><i class="fa fa-phone" aria-hidden="true"></i></span>
						<input type="text" placeholder="Phone" name="phone" required>
					</div>
					<div class="input-group">
						<span><i class="fa fa-dashboard" aria-hidden="true"></i></span>
						<input type="text" placeholder="Enroll Day" name="enrollDay" required>
					</div>
				
			</div>
			<div class="w3_info">
				<br>
				<br>
			
					<div class="input-group">
					
						<span><i class="fa fa-bell" aria-hidden="true">&ensp;Enroll Status&nbsp;</i></span>
						
						<tr>
							<td>
							<input type="radio"  name="enrollStatus" value="y" checked="checked"/>
							YES   
							<input type="radio"  name="enrollStatus" value="n"/>
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Dtap6&nbsp;</i></span>
						<tr>
						<td>
							<input type="radio"  name="dtap6" value="y" />
							YES   
							<input type="radio"  name="dtap6" value="n"  checked="checked"/>
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Hib6&ensp;&ensp;</i></span>
						<tr>
						<td>
							<input type="radio"  name="hib6" value="y" />
							YES   
							<input type="radio"  name="hib6" value="n" checked="checked"/>
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Polio6&nbsp;</i></span>
						<tr>
						<td>
							<input type="radio"  name="polio6"  value="y"/>
							YES   
							<input type="radio"  name="polio6"  value="n" checked="checked"/>
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Hepb6&nbsp;</i></span>
						<tr>
						<td>
							<input type="radio"  name="hepb6" value="y" />
							YES   
							<input type="radio"  name="hepb6" value="n" checked="checked" />
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Mmr12&nbsp;</i></span>
						<tr>
						<td>
							<input type="radio"  name="mmr12" value="y" />
							YES   
							<input type="radio"  name="mmr12" value="n" checked="checked" />
							NO
							</td>
						</tr>
					</div>

					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Var12&ensp;&nbsp;</i></span>
						<tr>
						<td>
							<input type="radio"  name="var12"  value="y" />
							YES   
							<input type="radio"  name="var12"  value="n" checked="checked" />
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Dtap15</i></span>
						<tr>
						<td>
							<input type="radio"  name="dtap15" value="y" />
							YES   
							<input type="radio"  name="dtap15" value="n" checked="checked" />
							NO
							</td>
						</tr>
					</div>
					<div class="input-group">
						<span><i class="fa fa-eyedropper" aria-hidden="true">&ensp;Polio15</i></span>
						<tr>
						<td>
							<input type="radio"  name="polio15"  value="y" />
							YES   
							<input type="radio"  name="polio15"  value="n" checked="checked" />
							NO
							</td>
						</tr>
						
					</div>
					
					<input type="submit" class="btn btn-danger btn-block" value="Confirm" onclick="return confirm('Do you confirm that all the data are correct?');"/>
				
				</form>
				<div id="footer">
					<div id="footer_bg">Daniel DayCare Center</div>
				</div>


			</div>
		</body>
		</html>