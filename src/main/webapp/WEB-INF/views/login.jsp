<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-1.11.3.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/jsApp/loginJavascript.js"/>"></script>

</head>
<body >
	"Bienvenido al tp
	<%=request.getContextPath()%>
	<div class="container" style="">

		<div class="jumbotron ">
			<h1>Bienvenido capo!!!</h1>
			<p>TP 2015 DDS</p>
		</div>


		<div class="row">
			<div class="col-sm-12">
				<h3>Entrega de febrero</h3>
				<p>Estamos haciendo lo que podemos para terminar el tp de
					diseño.</p>
				<p>"La esperanza es el peor de los males, pues prolonga el
					tormento del hombre."</p>
			</div>



			<div class="col-sm-12">

				<h3>Inicio de session</h3>
				<p>En el caso que este registrado ingrese el usuario y la
					contraseña.</p>
				<form:form action="menu" commandName="login"
					onsubmit="return validarCamposCompletos();">

					<div class="form-group">
						<form:label path="user">
							<spring:message text="usuario:" />
						</form:label>
						<form:input path="user" class="form-control"
							placeholder="Ingrese el usuario" />
					</div>


					<div class="form-group">
						<form:label path="password">
							<spring:message text="password:" />
						</form:label>
						<form:password path="password" class="form-control"
							placeholder="Ingrese la contraseña" />
					</div>

					<div>
						<input type="submit" value="Iniciar session" class="btn btn-info" />
						<a href="<%=request.getContextPath()%>/registro">Registrarse</a>
					</div>
					<br>
					<br>

				</form:form>
			</div>
			<hr width=100% align=left>
		</div>
	</div>

</body>
</html>