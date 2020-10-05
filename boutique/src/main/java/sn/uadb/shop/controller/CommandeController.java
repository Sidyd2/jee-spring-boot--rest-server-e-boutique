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

import sn.uadb.shop.entities.Commande;
import sn.uadb.shop.repositories.CommandeRepository;
import sn.uadb.shop.util.EntityException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/com")
public class CommandeController {

	@Autowired
	private CommandeRepository commandeRepository;
		
	//@RequestMapping(method=RequestMethod.GET, value="/commandes")
	@GetMapping("/commandes")
	public List<Commande> getAllCommande(){
		return commandeRepository.findAll();
	}
	
	@PostMapping("/commande") 
	public Commande saveCommande(@RequestBody Commande commande) {
		return commandeRepository.save(commande);
	}
	
	@GetMapping("/commande/{id}")
	public Commande findById(@PathVariable(value="id") int id) throws Exception {
		
		return commandeRepository.findById(id).orElseThrow(
				()->new Exception("Cet article n'existe pas "));
	}
	
	@PutMapping("/commande")
	public Commande updateCommande(@RequestBody Commande commande) {
		
		return commandeRepository.saveAndFlush(commande);
	}
	@DeleteMapping("/commande/{id}")
	public Boolean deleteCommande(@PathVariable(value="id") int id) throws EntityException {//throws EntityException {
		Boolean b = commandeRepository.existsById(id);
		System.out.println("test");
		if(!b) {
			System.out.println("test");
			//throw new EntityException("Cette commande n'existe pas ");
			}
		else {
			commandeRepository.deleteById(id);
		}
		return b;
	}
}
