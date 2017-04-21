package br.com.comerciobinario.DAO.PostgreSqlDAO;

import java.sql.SQLException;
import java.util.List;

import br.com.comerciobinario.DAO.CidadeDAO;
import br.com.comerciobinario.utils.Persistencia;
import br.com.comerciobinario.vo.Cidade;

public class CidadeImpDAO extends Persistencia<Cidade> implements CidadeDAO {

	@Override
	public void inserir(Cidade cidade) {
		inserir(cidade);
	}

	@Override
	public void alterar(Cidade cidade) {
		update(cidade);
	}

	@Override
	public void apagar(Cidade cidade) {
		delete(cidade);	
	}

	@Override
	public List<Cidade> listaTodosCidade() throws SQLException {
		List<Cidade> lista = null;
		try {
			lista = listaTodos();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cidade selecionaCidade(int id) throws SQLException {
		return null;
	}

}
