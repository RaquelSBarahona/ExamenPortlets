package com.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.portlet.entidades.Persona;

/**
 * Portlet implementation class PortletA
 */
public class PortletA extends GenericPortlet {


	public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }

  		@ProcessAction(name="enviarDatos")
  	    public void EnviarEvento(ActionRequest arg0, ActionResponse arg1) throws PortletException {
  			
  			String nombre = arg0.getParameter("nombre");
  			String direccion =arg0.getParameter("direccion");
  			int telefono = Integer.parseInt(arg0.getParameter("telefono"));
  			Persona persona = new Persona(nombre, direccion, telefono);
  			
  			QName qname = new QName("http://PruebaPracticaFinal.com", "Datos", "x");
  			arg1.setEvent(qname, persona );	
  			
  		}
  		
  		@ProcessAction(name="enviarDatos1")
  	    public void EnviarEvento1(ActionRequest arg0, ActionResponse arg1) throws PortletException {
  			
  			String nombre = arg0.getParameter("nombre");
  			String direccion =arg0.getParameter("direccion");
  			int telefono = Integer.parseInt(arg0.getParameter("telefono"));
  			Persona persona = new Persona(nombre, direccion, telefono);
  			
  			QName qname = new QName("http://PruebaPracticaFinal.com", "Datos1", "x");
  			arg1.setEvent(qname, persona );	
  			
  		}
  		
  		
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(PortletA.class);

}
