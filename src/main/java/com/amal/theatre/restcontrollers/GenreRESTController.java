package com.amal.theatre.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amal.theatre.entities.Genre;
import com.amal.theatre.repos.GenreRepository;

@RestController
@RequestMapping("/genre")
@CrossOrigin("*")
public class GenreRESTController {

    @Autowired
    GenreRepository genreRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    	public Genre getGenreById(@PathVariable("id") Long id) {
    		return  genreRepository.findById(id).get();
    	
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre); 
    }
   
}
