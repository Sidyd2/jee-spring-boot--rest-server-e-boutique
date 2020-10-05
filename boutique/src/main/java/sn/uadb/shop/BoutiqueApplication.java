package sn.uadb.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.uadb.shop.entities.Article;
import sn.uadb.shop.entities.Categorie;
import sn.uadb.shop.repositories.ArticleRepository;
import sn.uadb.shop.repositories.CategorieRepository;

@SpringBootApplication
public class BoutiqueApplication implements CommandLineRunner{

	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BoutiqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categorie c1 = new Categorie("ALIMENTAIRE") ;
		Categorie c2 = new Categorie("ELECTROMENANGER");
		Categorie c3 = new Categorie("BEAUTE") ;
		
		categorieRepository.save(c1);
		categorieRepository.save(c2);
		categorieRepository.save(c3);
		
		Article lait = new Article("Lait", "Lait naturel", 3000, 0, 300, "no image") ;
		lait.setCategorie(c1);
		articleRepository.save(lait) ;
		Article miel = new Article("Miel", "Miel naturel pure", 4000, 0, 200, "no image") ;
		miel.setCategorie(c1);
		articleRepository.save(miel) ;
		
		Article aspirateur = new Article("Aspirateur", "Aspirateur importé neuf", 50000, 0, 50, "no image") ;
		aspirateur.setCategorie(c2);
		articleRepository.save(aspirateur) ;
		
		Article lavelinge = new Article("Lave linge", "Lave linge importé neuf", 50000, 0, 30, "no image") ;
		lavelinge.setCategorie(c2);
		articleRepository.save(lavelinge) ;
		
		Article baume = new Article("Lait corporel", "Pour soin corporel", 3000, 0, 30, "no image") ;
		baume.setCategorie(c3);
		articleRepository.save(baume) ;
		Article parfum = new Article("Parfum corporel", "Bonne odeur corporel", 3000, 0, 200, "no image") ;
		parfum.setCategorie(c3);
		articleRepository.save(parfum) ;
		
	}
}
