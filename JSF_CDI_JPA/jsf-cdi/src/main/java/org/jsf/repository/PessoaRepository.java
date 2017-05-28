package org.jsf.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jsf.model.Pessoa;
import org.jsf.util.Transactional;

public class PessoaRepository implements GenericRepository<Pessoa>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Transactional
	@Override
	public Pessoa save(Pessoa obj) {
		this.em.persist(obj);
		return obj;
	}

	@Transactional
	@Override
	public Pessoa edit(Pessoa obj) {
		return this.em.merge(obj);
	}

	@Transactional
	@Override
	public Pessoa findOne(Long id) {
		return this.findOne(id);
	}

	@Transactional
	@Override
	public List<Pessoa> findAll() {

		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		CriteriaQuery<Pessoa> all = criteriaQuery.select(root);
		TypedQuery<Pessoa> allPessoa = em.createQuery(all);

		return allPessoa.getResultList();
	}

	@Transactional
	@Override
	public boolean remove(Pessoa obj) {
		try {
			Object _obj = em.merge(obj);
			this.em.remove(_obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
