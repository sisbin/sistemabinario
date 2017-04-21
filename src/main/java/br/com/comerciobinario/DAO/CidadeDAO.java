package br.com.comerciobinario.DAO;

import java.sql.SQLException;
import java.util.List;

import br.com.comerciobinario.vo.Cidade;

public interface CidadeDAO {
	
	void inserir(Cidade cidade);
	void alterar(Cidade cidade);
	void apagar(Cidade cidade);
	List<Cidade> listaTodosCidade() throws SQLException;
	Cidade selecionaCidade(int id) throws SQLException;

}
