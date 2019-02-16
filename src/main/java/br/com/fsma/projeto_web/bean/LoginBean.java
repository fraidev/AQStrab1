package br.com.fsma.projeto_web.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
//import javax.enterprise.context.ApplicationScoped;
//import javax.faces.view.ViewScoped;
//import javax.enterprise.context.RequestScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	
	private static final String USUARIO_LOGADO = "usuarioLogado";

	private static final long serialVersionUID = 1L;

	@Inject
	private HttpSession session;

	@PostConstruct
	public void init() {
		System.out.println("LoginBean.init();");
	}
}
