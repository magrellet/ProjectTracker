<html>
<head><title>Current projects</title></head>
<body>
<form><%--
	${allProject.name}</br> 
	${allProject.description} </br>
	${allProject.dueDate}
	
	--%>
	<table border="1">
		<g:each in="${allProject}" status="i" var="project">
			<tr>
				<td>${project.name}</td>
				<td>${project.description}</td>
				<td>${project.dueDate}</td>
			</tr>
		</g:each>
	</table>
	
	
	<!-- Project <input type="text" size="40" value="${project}"/>
	</br>
	Date <input type="text" value="${date}"> -->

</form>

</body>
</html>