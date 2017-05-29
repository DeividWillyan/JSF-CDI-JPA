package org.jsf.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void msgInfo(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMessage);
	}

	public static void msgErro(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMessage);
	}

}
