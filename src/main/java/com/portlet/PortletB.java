package com.portlet;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.portlet.entidades.Persona;

/**
 * Portlet implementation class PortletB
 */
public class PortletB extends GenericPortlet {

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
 
    @ProcessEvent(qname="{http://PruebaPracticaFinal.com}Datos")
    public void procesarMiEvento(EventRequest arg0, EventResponse arg1) throws PortletException, IOException {  
    	Event evento = arg0.getEvent();
		
		Persona Persona = (Persona) evento.getValue();
			
		arg0.setAttribute("persona", Persona);
    }


   
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(PortletB.class);

    
    
}
