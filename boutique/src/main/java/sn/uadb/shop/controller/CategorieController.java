package sn.uadb.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.uadb.shop.entities.Categorie;
import sn.uadb.shop.repositories.CategorieRepository;
import sn.uadb.shop.util.EntityException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/cat")
public class CategorieController {

	@Autowired
	private CategorieRepository categorieRepository;
		
	//@RequestMapping(method=RequestMethod.GET, value="/categories")
	@GetMapping("/categories")
	public List<Categorie> getAllCategorie(){
		return categorieRepository.findAll();
	}
	
	@PostMapping("/categorie") 
	public Categorie saveCategorie(@RequestBody Categorie categorie) {
		return categorieRepository.save(categorie);
	}
	
	@GetMapping("/categorie/{id}")
	public Categorie findById(@PathVariable(value="id") int id) throws Exception {
		
		return categorieRepository.findById(id).orElseThrow(
				()->new Exception("Cette categorie n'existe pas "));
	}
	
	@PutMapping("/categorie")
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		
		return categorieRepository.saveAndFlush(categorie);
	}
	@DeleteMapping("/categorie/{id}")
	public Boolean deleteCategorie(@PathVariable(value="id") int id) throws EntityException {//throws EntityException {
		Boolean b = categorieRepository.existsById(id);
		System.out.println("test");
		if(!b) {
			System.out.println("test");
			//throw new EntityException("Cette categorie n'existe pas ");
			}
		else {
			categorieRepository.deleteById(id);
		}
		return b;
	}
}
