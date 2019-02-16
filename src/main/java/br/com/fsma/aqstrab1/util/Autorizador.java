package br.com.fsma.aqstrab1.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;


public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent evento) {
		System.out.println("afterPhase(PhaseEvent evento)");
		FacesContext context = evento.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();
		System.out.println("Nome da página: " + nomePagina);
		if (nomePagina.endsWith("/login/login.xhtml") ||
			nomePagina.endsWith("/login/recuperarSenha.xhtml") || 
			nomePagina.endsWith("/login/novoLogin.xhtml")) {
			return;
		}
		
		// Redirecionamento para login.xhtml
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/view/login/login?faces-redirect=true");
		context.renderResponse();
	} 

	@Override
	public void beforePhase(PhaseEvent evento) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
