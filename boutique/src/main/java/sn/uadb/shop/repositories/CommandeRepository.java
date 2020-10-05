package sn.uadb.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.uadb.shop.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
