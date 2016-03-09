<%@page import="com.portlet.entidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

Portlet B


<%
Persona persona = (Persona) request.getAttribute("persona");

if (persona != null) {
%>

<form action="" method="post">
	<input type="text" name="nombre" value=<%= persona.getNombre() %>/>
	<input type="text" name="domicilio" value=<%= persona.getDireccion() %> />
	<input type="text" name="telefono" value=<%= persona.getTelefono() %>/>
</form>

<%
} else {
%>
<form action="" method="post">
	<input type="text" name="nombre" placeholder="Nombre"/>
	<input type="text" name="domicilio" placeholder="Domicilio"/>
	<input type="text" name="telefono" placeholder="Telefono"/>
</form>

<%}%>