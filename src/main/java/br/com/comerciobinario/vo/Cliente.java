package br.com.comerciobinario.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
    @JoinColumn(nullable = false, name = "pessoa_id", referencedColumnName = "id") 
	private Pessoa pessoa;
}
