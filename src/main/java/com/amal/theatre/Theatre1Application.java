package com.amal.theatre;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.amal.theatre.entities.Genre;
import com.amal.theatre.entities.Pieceth;

@SpringBootApplication
public class Theatre1Application implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
	SpringApplication.run(Theatre1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Pieceth.class,Genre.class);
	}
	

	
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}


}
