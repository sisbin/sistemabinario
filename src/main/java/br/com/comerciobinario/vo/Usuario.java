package br.com.comerciobinario.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
    @JoinColumn(nullable = false, name = "perfil_id", referencedColumnName = "id") 
	private Perfil perfil;
	@Column
	private String login;
	@Column
	private String senha;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    @JoinColumn(nullable = false, name = "pessoa_id", referencedColumnName = "id") 
	private Pessoa pessoa;


}
