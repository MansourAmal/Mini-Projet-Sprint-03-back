package com.amal.theatre.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amal.theatre.dto.PiecethDTO;
import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;
import com.amal.theatre.repos.PiecethRepository;

@Service
public class PiecethServiceImpl implements PiecethService {
    @Autowired
    PiecethRepository piecethRepository;
    
    @Autowired
    ModelMapper modelMapper;


    @Override
    public PiecethDTO savePieceth(PiecethDTO p) {
        return convertEntityToDto( piecethRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public PiecethDTO updatePieceth(PiecethDTO p) {
        return convertEntityToDto( piecethRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public void deletePieceth(Pieceth p) {
        piecethRepository.delete(p);
    }

    @Override
    public void deletePiecethById(Long id) {
        piecethRepository.deleteById(id);
    }

    @Override
    public PiecethDTO getPieceth(Long id) {
        return convertEntityToDto(piecethRepository.findById(id).get());
    }

    @Override
    public List<PiecethDTO> getAllPieceths() {
        return piecethRepository.findAll().stream()
        		.map(this::convertEntityToDto)
        		.collect(Collectors.toList());

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
		return piecethRepository.findByGenre(genre) ;
	}
	
	@Override
	public PiecethDTO convertEntityToDto(Pieceth pieceth) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	    PiecethDTO piecethDTO = modelMapper.map(pieceth, PiecethDTO.class);
	    return piecethDTO;
	}

	@Override
	public Pieceth convertDtoToEntity(PiecethDTO piecethDto) {
	    Pieceth pieceth = modelMapper.map(piecethDto, Pieceth.class);
	    return pieceth;
	}
    
    
}