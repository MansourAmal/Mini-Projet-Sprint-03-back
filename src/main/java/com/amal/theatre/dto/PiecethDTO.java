package com.amal.theatre.dto;

import java.util.Date;

import com.amal.theatre.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PiecethDTO {
	private Long idPieceth;
    private String nomPieceth;
    private String auteurPieceth;
    private Date dateCreation;
    private Genre genre;
    private String nomGen;


}
