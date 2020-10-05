package sn.uadb.shop.entities;

import java.security.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCommande;
	private Timestamp dateHeure;
	private String numTel;
	private String adresse;
	private String statut; 

	@ManyToMany
	@JoinTable(name="lignecmd",
			joinColumns= {@JoinColumn(name="idCommande")},
			inverseJoinColumns={@JoinColumn(name="idArticle")})
	private Set<LigneCmd> ligneCmd= new HashSet<LigneCmd>();
	
	
	
}
