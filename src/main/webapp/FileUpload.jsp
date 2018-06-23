<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div align="center">
		<h1>File Upload to DB</h1>
		<table border="0">
			<form method="post" action="doUpload.form" enctype="multipart/form-data">
			<tr>
				<td>Pick file :</td>
				<td><input type="file" name="fileUploadss" size="50" /></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="fid"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Upload" /></td>
			</tr>
			</form>
			
			<c:forEach items="${filesData}" var="fObj">
				<tr>
					<td colspan="2">
					    <a	href="download.form?fid=<c:out value='${fObj[0]}'/>">
						<c:out	value="${fObj[1]}" /> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
   

</body>
</html>