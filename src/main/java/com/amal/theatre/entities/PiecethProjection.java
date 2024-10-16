package com.amal.theatre.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPieceth", types = { Pieceth.class })
public interface PiecethProjection {
    String getNomPieceth();
}
