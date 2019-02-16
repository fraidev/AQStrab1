package br.com.fsma.aqstrab1.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		System.out.println("LoginBean.init();");
	}
}
