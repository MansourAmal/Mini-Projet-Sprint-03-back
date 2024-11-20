package com.amal.theatre.service;

import java.util.List;


import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;

public interface PiecethService {
	Pieceth savePieceth(Pieceth p);
    Pieceth updatePieceth(Pieceth p);
    void deletePieceth(Pieceth p);
    void deletePiecethById(Long id);
    Pieceth getPieceth(Long id);
    List<Pieceth> getAllPieceths();
    List<Pieceth> findByNomPieceth(String nom);
    List<Pieceth> findByNomPiecethContains(String nom);
    List<Pieceth> findByNomAuteur(String nom, String auteur);
    List<Pieceth> findByGenre(Genre genre);
    List<Pieceth> findByGenreId(Long genreId);
    List<Pieceth> findByOrderByNomPiecethAsc();
    List<Pieceth> trierPiecethsNomsAuteurs();
    
   
}
