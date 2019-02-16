package aqstrab1.bean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import aqstrab1.dao.EmpresaDAO;
import aqstrab1.domain.Empresa;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaDAO empresaDao;
	private Empresa empresa;

//	@PostConstruct
//	public void init() {
//		System.out.println("IndexBean.init();");
//	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void upload() {
		this.empresa = new Empresa();
		this.empresa.setCep("teste");
		this.empresa.setRazaoSocial("teste");
		this.empresa.setCnpj("teste");
		this.empresa.setLogadouro("teste");
		long num = 1;
		this.empresa.setId(num);
	    empresaDao.adiciona(this.empresa);
	}
}
