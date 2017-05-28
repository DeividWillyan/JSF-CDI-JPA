package org.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jsf.model.Pessoa;
import org.jsf.repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository repository;

	@Inject
	private Pessoa pessoa;

	private List<Pessoa> pessoas;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void salvar() {
		try {
			repository.save(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			if (!this.pessoa.getNome().isEmpty()) {
				repository.edit(pessoa);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Pessoa pessoa) {
		try {
			System.out.println(pessoa.toString());
			repository.remove(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void lista() {
		pessoas = repository.findAll();
	}

}
