package com.amal.theatre.service;

import java.util.List;

import com.amal.theatre.dto.PiecethDTO;
import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;

public interface PiecethService {
	PiecethDTO savePieceth(PiecethDTO p);
    PiecethDTO updatePieceth(PiecethDTO p);
    void deletePieceth(Pieceth p);
    void deletePiecethById(Long id);
    PiecethDTO getPieceth(Long id);
    List<PiecethDTO> getAllPieceths();
    List<Pieceth> findByNomPieceth(String nom);
    List<Pieceth> findByNomPiecethContains(String nom);
    List<Pieceth> findByNomAuteur(String nom, String auteur);
    List<Pieceth> findByGenre(Genre genre);
    List<Pieceth> findByGenreId(Long genreId);
    List<Pieceth> findByOrderByNomPiecethAsc();
    List<Pieceth> trierPiecethsNomsAuteurs();
    Pieceth convertDtoToEntity(PiecethDTO piecethDto);
    PiecethDTO convertEntityToDto(Pieceth pieceth);
   
}
