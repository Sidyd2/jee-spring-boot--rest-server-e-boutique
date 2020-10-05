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

import sn.uadb.shop.entities.Article;
import sn.uadb.shop.repositories.ArticleRepository;
import sn.uadb.shop.util.EntityException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
		
	//@RequestMapping(method=RequestMethod.GET, value="/articles")
	@GetMapping("/articles")
	public List<Article> getAllArticle(){
		return articleRepository.findAll();
	}
	
	@PostMapping("/article") 
	public Article saveArticle(@RequestBody Article article) {
		return articleRepository.save(article);
	}
	
	@GetMapping("/article/{id}")
	public Article findById(@PathVariable(value="id") int id) throws Exception {
		
		return articleRepository.findById(id).orElseThrow(
				()->new Exception("Cet article n'existe pas "));
	}
	
	@PutMapping("/article")
	public Article updateArticle(@RequestBody Article article) {
		
		return articleRepository.saveAndFlush(article);
	}
	@DeleteMapping("/article/{id}")
	public Boolean deleteArticle(@PathVariable(value="id") int id) throws EntityException {//throws EntityException {
		Boolean b = articleRepository.existsById(id);
		System.out.println("test");
		if(!b) {
			System.out.println("test");
			//throw new EntityException("Cet article n'existe pas ");
			}
		else {
			articleRepository.deleteById(id);
		}
		return b;
	}
}
