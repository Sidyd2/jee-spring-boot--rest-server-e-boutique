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

import sn.uadb.shop.entities.LigneCmd;
import sn.uadb.shop.repositories.LigneCmdRepository;
import sn.uadb.shop.util.EntityException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/lcm")
public class LigneCmdController {

	@Autowired
	private LigneCmdRepository ligneCmdRepository;
		
	//@RequestMapping(method=RequestMethod.GET, value="/lignecmds")
	@GetMapping("/lignecmds")
	public List<LigneCmd> getAllLigneCmd(){
		return ligneCmdRepository.findAll();
	}
	
	@PostMapping("/lignecmd") 
	public LigneCmd saveLigneCmd(@RequestBody LigneCmd lignecmd) {
		return ligneCmdRepository.save(lignecmd);
	}
	
	@GetMapping("/lignecmd/{id}")
	public LigneCmd findById(@PathVariable(value="id") int id) throws Exception {
		
		return ligneCmdRepository.findById(id).orElseThrow(
				()->new Exception("Cet lignecmd n'existe pas "));
	}
	
	@PutMapping("/lignecmd")
	public LigneCmd updateLigneCmd(@RequestBody LigneCmd lignecmd) {
		
		return ligneCmdRepository.saveAndFlush(lignecmd);
	}
	@DeleteMapping("/lignecmd/{id}")
	public Boolean deleteLigneCmd(@PathVariable(value="id") int id) throws EntityException {//throws EntityException {
		Boolean b = ligneCmdRepository.existsById(id);
		System.out.println("test");
		if(!b) {
			System.out.println("test");
			//throw new EntityException("Cette lignecmd n'existe pas ");
			}
		else {
			ligneCmdRepository.deleteById(id);
		}
		return b;
	}
}
