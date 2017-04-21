package br.com.comerciobinario.vo;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	
	@Embedded
	private Endereco endereco;
	
	@ElementCollection
	@CollectionTable (
	 name ="telefone_pessoa",
	 joinColumns = @JoinColumn ( name = "id") )
	@Column ( name =" telefone ")	
	private Map<String, String> telefones;
	private String skype;
	private String twitter;
	private String facebook;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Map<String, String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Map<String, String> telefones) {
		this.telefones = telefones;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}


}
