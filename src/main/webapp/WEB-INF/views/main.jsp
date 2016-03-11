<%@page import="com.tpdisenio.recetas.model.Usuario"%>
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
<link href="<c:url value="/resources/css/bootstrap.css" />"rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/jsApp/menuCommonJavascript.js"/>"></script>

</head>


<body>



<jsp:include page="/WEB-INF/views/top.jsp"></jsp:include>  <%--  --%>

<%HttpSession session =request.getSession(false); %>
<%Usuario usuario=(Usuario)session.getAttribute("usuario");%>
<%=usuario.getUsuario()%>
<%=usuario.getNombre()%>
<%=usuario.getPassword()%>



		<div class="jumbotron ">
		
		
		
		
		
			<h1>Iniciaste Sesion Papu!!!!</h1>
			<p>TP 2015 DDS</p>
		
		
<%-- 			${usuarioLogueado.getUser()} esto viene del formulario --%>
<%-- 			${usuarioLogueado.getPassword()} --%>
			<br>
			
			
		<label id="usuarioAux">
		Usuario:
		</label>
		 <input id="usuarioAux" type="text" value="${usuario.getUsuario()}" readonly="readonly"/>
		 
		<br>
		<label id="passwordAux">
		Password:
		</label>
		 <input id="passwordAux" type="password" value="${usuario.getPassword()}" readonly="readonly"/>
		<br>
		Cantidad de grupos:${usuario.getGrupos().size()}
			<br>
			${mensajeDelServiceHome}
			



<form:form action="editar" commandName="auxBean">
	<form:select path="group" items="${gruposMap}"> </form:select>
   <input type="submit" value="Submit">
</form:form>


<form:form action="recetasPersonales" method="GET">
	<input type="submit" value="Crear Receta">
</form:form>


	</div>
	

  </div><%--  --%>

</body>
</html>