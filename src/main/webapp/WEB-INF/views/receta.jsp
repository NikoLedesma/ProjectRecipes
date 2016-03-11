<%@page import="java.util.Iterator"%>
<%@page import="com.tpdisenio.recetas.model.Receta"%>
<%@page import="java.util.Set"%>
<%@page import="com.tpdisenio.recetas.model.LoginForm"%>
<%@page import="com.tpdisenio.recetas.bean.UsuarioBean"%>
<%@page import="com.tpdisenio.recetas.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-1.11.3.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.css" />"rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/jsApp/menuCommonJavascript.js"/>"></script>
</head>
<body>


<jsp:include page="/WEB-INF/views/top.jsp"></jsp:include>  <%--  --%>

	<h1>Recetas del usuario ABM</h1>
<%HttpSession session =request.getSession(false); %>
<%Usuario usuario=(Usuario)session.getAttribute("usuario");%>
Usuario:<%=usuario.getUsuario()%><br>
${usuario.getUsuario()}
${usuario.getReceta()}

<%
 Set<Receta> a = usuario.getReceta();
Iterator it=a.iterator();

while(it.hasNext()){
	Receta r = (Receta) it.next() ;%>
	<%=r.getCalificacion() + r.getNombre() %>
<%}
%>
	<form:form commandName="recetaBean">

		<form:label path="id">
			<spring:message text="Id:" />
		</form:label>
		<form:input path="id" readonly="true" style="background:#ccccb3" value="--------------------------------"/>


		<form:label path="nombre">
			<spring:message text="Nombre:" />
		</form:label>
		<form:input path="nombre" />


		<form:label path="explicacion">
			<spring:message text="Explicacion:" />
		</form:label>
		<form:input path="explicacion" />

		
		<form:label path="calificacion">
			<spring:message text="Calificacion:" />
		</form:label>
		<form:select path="calificacion" items="${calAux }">  </form:select>
		

<%-- 		<form:label path="nombre_usuario"> --%>
<%-- 			<spring:message text="usuario:" /> --%>
<%-- 		</form:label> --%>
<%-- 		<form:input path="nombre_usuario" /> --%>

<%-- 		<form:label path="nombre_grupo"> --%>
<%-- 			<spring:message text="grupo:" /> --%>
<%-- 		</form:label> --%>
<%-- 		<form:input path="nombre_grupo" /> --%>

<%-- 	<% String[] lista ={"lista","opa","peperina"} ;%> --%>
						
		<input type="submit" value="Crear Receta" />

	</form:form>


<p> ${usuario.getUsuario()}</p>
<p> ${usuario.getNombre()}</p>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Calificacion</th>
			<th>Grupo</th>
			<th>XXXXX</th>
		</tr>

		<c:forEach items="${lista}" var="k">
			<tr>
				<td>${k}</td>
				<td>5 estrellas</td>
				<td>NO</td>
				<td><a href="?accion=editar">editar</a>| <a
					href="?accion=eliminar">eliminar</a>|
					<button>eliminar</button></td>
			</tr>

		</c:forEach>

	</table>

	<%-- <form method="get"> --%>
	<!-- 	<label for="recetaNombre"></label> -->
	<!-- 	<input name="recetaNombre" type="text" > -->
	<!-- 	<input type="submit" value="Mostrar recetas" /> -->
	<%-- </form> --%>






</div>
</body>
</html>