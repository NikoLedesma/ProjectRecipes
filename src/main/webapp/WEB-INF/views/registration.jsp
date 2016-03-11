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
<script src="<c:url value="/resources/jsApp/registrationJavascript.js"/>"></script>


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


			<div class="col-sm-12" id="divRegistro">

				<h3>Registro de usuario</h3>
				<p>Registrese si todavia no fue registrado para luego iniciar
					sesion.</p>


				<form:form action="registracion" commandName="usuarioBean" onsubmit="return validarCampos();">

					<div class="form-group">
						<form:label path="usuario">
							<spring:message text="usuario*:" />
						</form:label>
						<form:input path="usuario" class="form-control"
							placeholder="Ingrese el usuario" />
					</div>



					<div class="form-group">
						<form:label path="password">
							<spring:message text="pasword*:" />
						</form:label>
						<form:password path="password" class="form-control"
							placeholder="Ingrese el password" />
					</div>

					<div class="form-group">
						<form:label path="nombre">
							<spring:message text="nombre*:" />
						</form:label>
						<form:input path="nombre" class="form-control"
							placeholder="Ingrese el nombre" />
					</div>

					<div class="form-group">
						<form:label path="altura">
							<spring:message text="altura*:" />
						</form:label>
						<form:input path="altura" class="form-control"
							placeholder="Ingrese la altura" />
					</div>

					<!--  -->
					<!--  -->
					<!--  -->
					<!--  -->


					<div class="form-group">
						<form:label path="edad">
							<spring:message text="edad*:" />
						</form:label>
						<form:select path="edad" class="form-control" >
							<form:option value="-1" label="--- Seleccione una edad ---" />
							<%
								for (int i = 18; i < 71; i++) {
											out.write("<option value=\"" + i + "\">" + i
													+ "</option>");
										}
							%>
						</form:select>
					</div>

					<div class="form-group">
						<form:label path="sexo">
							<spring:message text="sexo*:"/>
						</form:label>
						
						<form:radiobutton path="sexo" value='H' checked="checked" /> Hombre						
						<form:radiobutton path="sexo" value='M'/> Mujer
					</div>



					<div class="form-group">
						<label for="cond">Condiciones:</label> <label
							class="checkbox-inline"> <form:checkbox
								path="condiciones" value="celiaco" />Celiaco
						</label> <label class="checkbox-inline"> <form:checkbox
								path="condiciones" value="hipertenso" />Hipertenso
						</label> <label class="checkbox-inline"> <form:checkbox
								path="condiciones" value="diabetico" />Diabetico
						</label>
					</div>
					<div>
					<input type="submit" class="btn btn-info" value="Registrarme" />
					</div>
				</form:form>
			</div>

		</div>
	</div>

</body>
</html>