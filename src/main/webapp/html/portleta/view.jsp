<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var = "urlDatos" name = "enviarDatos" />
<portlet:actionURL var = "urlDatos1" name = "enviarDatos1" />

Portlet A

<form method="post">
	<input type="submit" value="PortletB" formaction="<%=urlDatos%>">
    <input type="submit"  value="PortletC" formaction="<%=urlDatos1%>">
	<div><input type="text" name="nombre" placeholder="Nombre"/></div>
	<div><input type="text" name="domicilio" placeholder="Domicilio"/></div>
	<div><input type="text" name="telefono" placeholder="Telefono"/></div>
	
</form>



