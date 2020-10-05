package sn.uadb.shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.uadb.shop.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	List<Article> findByTitleContaining(String title);
}
