package sn.uadb.shop.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Article")
public class Article implements Serializable{


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idArticle;
	private String title;
	private String description;
	private int prix;
	private int liked;
	private int quantite;
	@Lob
	private String photo;
	@ManyToOne
	@JoinColumn(name="id_categorie")
	
	private Categorie categorie;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String title, String description, int prix, int liked, int quantite, String photo) {
		super();
		this.title = title;
		this.description = description;
		this.prix = prix;
		this.liked = liked;
		this.quantite = quantite;
		this.photo = photo;
	}

	public void setCategorie(Categorie c) {
		this.categorie = c ;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getLike() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	
}
