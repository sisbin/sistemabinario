package br.com.comerciobinario.utils;

import java.lang.reflect.Field;
import java.sql.Date;

import org.hibernate.criterion.MatchMode;

public class Funcoes {

	public String[] criteriosString = { "Começando com", "Terminando com", "Contendo", "Igual" };
	public String[] criteriosInteger = { "Igual", "Diferente", "Maior que", "Maior ou igual que", "Menor que",
			"Menor ou igual que" };
	public String[] titulacao = { "1 - Especialista", "2 - Mestre", "3 - Doutorado", "4 - Pós-Doutorado" };
	private String init;
	private String end;

	public static String tipoDado(Class<?> cls, String campo) {
		Field strField = null;
		try {
			strField = cls.getDeclaredField(campo);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (strField.getType().equals(String.class)) {
			return "String";
		}
		if (strField.getType().equals(int.class)) {
			return "Inteiro";
		}
		if (strField.getType().equals(Date.class)) {
			return "Data";
		}
		return null;
	}

	public String criterio(String criterio) {
		if (criterio == "Começando com") {
			setInit("");
			setEnd("%");
			return "LIKE";
		}
		if (criterio == "Terminando com") {
			setInit("%");
			setEnd("");
			return "LIKE";
		}
		if (criterio == "Contendo") {
			setInit("%");
			setEnd("%");
			return "LIKE";
		}
		if (criterio == "Igual") {
			setInit("");
			setEnd("");
			return "=";
		}
		if (criterio == "Diferente") {
			setInit("");
			setEnd("");
			return "<>";
		}
		if (criterio == "Maior que") {
			setInit("");
			setEnd("");
			return ">";
		}
		if (criterio == "Maior ou igual que") {
			setInit("");
			setEnd("");
			return ">=";
		}
		if (criterio == "Menor que") {
			setInit("");
			setEnd("");
			return "<";
		}
		if (criterio == "Menor ou igual que") {
			setInit("");
			setEnd("");
			return "=<";
		}
		return null;
	}

	/**
	 * Retorna todos os registros da tabela (classe) informada
	 * 
	 * @param objClass
	 * @return List<Object>
	 */
	public static MatchMode condicoes(String condicao) {
		if (condicao == "Começando com") {
			return MatchMode.START;
		} else if (condicao == "Terminando com") {
			return MatchMode.END;
		} else if (condicao == "Contendo") {
			return MatchMode.ANYWHERE;
		}
		if (condicao == "Igual") {
			return MatchMode.EXACT;
		}
		return null;
	}

	// Getters and Setters para Init e End
	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
