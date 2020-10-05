package sn.uadb.shop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;


@Entity
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="article", 
        referencedColumnName="idarticle"),
    @PrimaryKeyJoinColumn(name="commande",
        referencedColumnName="idcommande")
})
public class LigneCmd {
 
	
	@Id
	private String idLigneCmd;
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	private int quantite;
	
	
	
}
