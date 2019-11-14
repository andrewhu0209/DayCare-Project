<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>DayCare Student Data</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
						<%	
							Date date = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
							%>
							<%=sdf.format(date)%>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">DayCare Student Data</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Teacher List
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								Teacher ID
							</td>
							<td>
								Teacher Name
							</td>
						</tr>
						<%
							List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
							for(int i=0;i<teachers.size();i++){
								Teacher teacher = teachers.get(i);
								%>
						<tr class="row<%=i % 2 + 1%>">
							<td>
								<%=teacher.getTeacherId()%>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/listAlarmStudent?teacherId=<%=teacher.getTeacherId()%>"> <%=teacher.getName()%> </a>
								
								
							</td>
						</tr>
								<%
							}
						%>
						<tr class="table_header">
							<td  colspan="2">
								<a href="<%=request.getContextPath()%>/listAlarmStudent"> All Student Data </a>			
							</td>
					</tr>
					</table>
					<p>
						<input type="button" class="button" value="Back To Login" onclick="location='login'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				Daniel DayCare Center
				</div>
			</div>
		</div>
	</body>
</html>
