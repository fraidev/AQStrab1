
package aqstrab1.dao;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import aqstrab1.domain.Empresa;

@Named
@RequestScoped
public class EmpresaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private DAO<Empresa> dao;

	@PostConstruct
	void init() {
		this.dao = new DAO<Empresa>(this.em, Empresa.class);
	}
	@Inject
	private EntityManager em;
	
//	public boolean existe(Empresa empresa) {
//		
//		TypedQuery<Empresa> query = em.createQuery(
//				  " select u from Usuario u "
//				+ " where u.email = :pLogin and u.senha = :pSenha", Empresa.class);
//		
//		query.setParameter("pLogin", empresa.getLogin());
//		query.setParameter("pSenha", empresa.getSenha());
//		try {
//			@SuppressWarnings("unused")
//			Usuario resultado = query.getSingleResult();
//			return true;
//		} catch (NoResultException ex) {
//			return false;
//		}
//	}
	
//	public Empresa buscaUsuarioPelaAutenticacao(Empresa usuario) {
//		StringBuilder jpql = new StringBuilder();
//		jpql.append(" select u from Usuario u ");
//		jpql.append(" where ");
//		jpql.append("       u.login = :pLogin ");
//		jpql.append("   and u.senha = :pSenha ");
//		
//		TypedQuery<Empresa> query = em.createQuery(jpql.toString() , Empresa.class);
//		
//		query.setParameter("pLogin", usuario.getLogin());
//		query.setParameter("pSenha", usuario.getSenha());
//		try {
//			return query.getSingleResult();
//		} catch (NoResultException ex) {
//			return null;
//		}
//	}

	public void adiciona(Empresa empresa) {
		dao.adiciona(empresa);
	}

	public void atualiza(Empresa empresa){
		em.merge(empresa);
	}

	public void remove(Empresa empresa) {
		dao.remove(empresa);
	}

	public Empresa buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}

//	public List<Empresa> listaTodosPaginada(int firstResult, int maxResults) {
//		return dao.listaTodosPaginada(firstResult, maxResults);
//	}

	public Empresa buscaPorEmail(String email) {
		String jpql = " select u from Usuario u where u.email = :pEmail";
		TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
		query.setParameter("pEmail", email.trim().toLowerCase());
		try {
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}
}