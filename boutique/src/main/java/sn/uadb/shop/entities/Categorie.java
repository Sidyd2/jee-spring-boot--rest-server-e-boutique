package sn.uadb.shop.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie implements Serializable{

	
	public Categorie() {
		super();
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategorie;
	private String nomCategorie;
	@OneToMany(mappedBy="categorie")
	@JsonBackReference
	private List<Article> article;
	
	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
@JsonIgnore
	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}
	
}
