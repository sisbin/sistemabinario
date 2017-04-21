package br.com.comerciobinario.utils;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.comerciobinario.DAO.CidadeDAO;
import br.com.comerciobinario.DAO.PostgreSqlDAO.CidadeImpDAO;
import br.com.comerciobinario.vo.Cidade;
import br.com.comerciobinario.vo.Estado;

@ManagedBean
public class Teste {

	public String generate() {

		EntityManager entitymanager = EntityManagerUtil.getEntityManager();
		/*
		entitymanager.getTransaction().begin();

		Estado estado = new Estado();
		estado.setUf("Bahia");
		estado.setSigla("BA");

		Cidade cidade = new Cidade();
		cidade.setNome("Teixeira de Freitas");
		cidade.setEstado(estado);

		CidadeDAO cidadeDao = new CidadeImpDAO();
		cidadeDao.inserir(cidade);
		
		entitymanager.close();
		*/
		
		return "";

	}

}
