package com.amal.theatre;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;
import com.amal.theatre.repos.PiecethRepository;

@SpringBootTest
class Theatre1ApplicationTests {

	 @Autowired
	    private PiecethRepository piecethRepository;

	    @Test
	    public void testCreatePieceth() {
	        Pieceth pieceth = new Pieceth("Hamlet", "William Shakespeare", new Date());
	        piecethRepository.save(pieceth);
	    }
	    @Test
	    public void testFindPieceth() {
	        Pieceth p = piecethRepository.findById(2L).get();
	        System.out.println(p);
	    }

	    @Test
	    public void testUpdatePieceth() {
	        Pieceth p = piecethRepository.findById(2L).get();
	        p.setAuteurPieceth("Shakespeare"); 
	        piecethRepository.save(p);
	    }

	    @Test
	    public void testDeletePieceth() {
	        piecethRepository.deleteById(1L);
	    }

	    @Test
	    public void testListerTousPieceth() {
	        List<Pieceth> pieceths = piecethRepository.findAll();
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }
	    
	    @Test
	    public void testFindByNomPieceth() {
	        List<Pieceth> pieceths = piecethRepository.findByNomPieceth("Hamlet");
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }

	    @Test
	    public void testFindByNomPiecethContains() {
	        List<Pieceth> pieceths = piecethRepository.findByNomPiecethContains("Ham");
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }
	    
	    @Test
	    public void testFindByNomAuteur() {
	        List<Pieceth> pieceths = piecethRepository.findByNomAuteur("Hamlet", "William Shakespeare");
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }
	    
	    @Test
	    public void testfindByGenre() {
	        Genre genre = new Genre();
	        genre.setIdGen(2L); 
	        List<Pieceth> pieceths = piecethRepository.findByGenre(genre);
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }
	    
	    @Test
	    public void testFindByGenreId() {
	        List<Pieceth> pieceths = piecethRepository.findByGenre_IdGen(1L); 
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }
	    
	    @Test
	    public void testfindByOrderByNomPiecethAsc() {
	        List<Pieceth> pieceths = piecethRepository.findByOrderByNomPiecethAsc();
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }
	    
	    @Test
	    public void testTrierPiecethsNomsAuteurs() {
	        List<Pieceth> pieceths = piecethRepository.trierPiecethsNomsAuteurs();
	        for (Pieceth p : pieceths) {
	            System.out.println(p);
	        }
	    }

}
