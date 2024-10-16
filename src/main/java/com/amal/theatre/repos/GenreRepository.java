package com.amal.theatre.repos;


import org.springframework.data.jpa.repository.JpaRepository;


import com.amal.theatre.entities.Genre;


public interface GenreRepository extends JpaRepository<Genre, Long>{
	
	

}
