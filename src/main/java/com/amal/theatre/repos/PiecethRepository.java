package com.amal.theatre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;

@RepositoryRestResource(path = "rest")
public interface PiecethRepository extends JpaRepository<Pieceth, Long>{
	List<Pieceth> findByNomPieceth(String nom);
    List<Pieceth> findByNomPiecethContains(String nom);
    List<Pieceth> findByGenre_IdGen(Long id);
    List<Pieceth> findByOrderByNomPiecethAsc();
    
    @Query("select p from Pieceth p where p.nomPieceth like %:nom% and p.auteurPieceth = :auteur")
    List<Pieceth> findByNomAuteur(@Param("nom") String nom, @Param("auteur") String auteur);
    
    @Query("select p from Pieceth p where p.genre = ?1")
    List<Pieceth> findByGenre(Genre genre);

    @Query("select p from Pieceth p order by p.nomPieceth ASC, p.auteurPieceth DESC")
    List<Pieceth> trierPiecethsNomsAuteurs();
}
