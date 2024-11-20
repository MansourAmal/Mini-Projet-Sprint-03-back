package com.amal.theatre.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;
import com.amal.theatre.repos.ImageRepository;
import com.amal.theatre.repos.PiecethRepository;

@Service
public class PiecethServiceImpl implements PiecethService {
	@Autowired
	PiecethRepository piecethRepository;
	
	@Autowired
	ImageRepository  imageRepository;

	

	
	@Override
	public Pieceth savePieceth(Pieceth p) {
		return piecethRepository.save(p);
	}

	/*@Override
	public PiecethDTO updatePieceth(PiecethDTO p) {
		return convertEntityToDto(piecethRepository.save(convertDtoToEntity(p)));
	}*/

	@Override
	public Pieceth updatePieceth(Pieceth p) {
		//Long oldPieceImageId = this.getPieceth(p.getIdPieceth().getImage().getIdImage());
		//Long newPieceImageId = p.getImage().getIdImage();
		Pieceth pieceUpdated = piecethRepository.save(p);
		//if (oldPieceImageId != newPieceImageId) // si l'image a été modifiée
			//imageRepository.deleteById(oldPieceImageId);
		return pieceUpdated;
	}

	@Override
	public void deletePieceth(Pieceth p) {
		piecethRepository.delete(p);
	}

	@Override
	public void deletePiecethById(Long id) {
		 Pieceth p = getPieceth(id);
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
			} catch (IOException e) {
			e.printStackTrace();
			}
		piecethRepository.deleteById(id);
	}
	


	@Override
	public Pieceth getPieceth(Long id) {
		return piecethRepository.findById(id).get();
	}

	@Override
	public List<Pieceth> getAllPieceths() {
		return piecethRepository.findAll();

	}

	@Override
	public List<Pieceth> findByNomPieceth(String nom) {
		return piecethRepository.findByNomPieceth(nom);

	}

	@Override
	public List<Pieceth> findByNomPiecethContains(String nom) {
		return piecethRepository.findByNomPiecethContains(nom);

	}

	@Override
	public List<Pieceth> findByGenreId(Long genreId) {
		return piecethRepository.findByGenre_IdGen(genreId);

	}

	@Override
	public List<Pieceth> findByOrderByNomPiecethAsc() {
		return piecethRepository.findByOrderByNomPiecethAsc();

	}

	@Override
	public List<Pieceth> trierPiecethsNomsAuteurs() {
		return piecethRepository.trierPiecethsNomsAuteurs();

	}

	@Override
	public List<Pieceth> findByNomAuteur(String nom, String auteur) {
		return piecethRepository.findByNomAuteur(nom, auteur);
	}

	@Override
	public List<Pieceth> findByGenre(Genre genre) {
		return piecethRepository.findByGenre(genre);
	}

	

	
}