package com.amal.theatre.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amal.theatre.dto.PiecethDTO;
import com.amal.theatre.entities.Pieceth;
import com.amal.theatre.service.PiecethService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PiecethRESTController {
    
    @Autowired
    PiecethService piecethService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PiecethDTO> getAllPieceths() {
        return piecethService.getAllPieceths();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public PiecethDTO getPiecethById(@PathVariable("id") Long id) {
        return piecethService.getPieceth(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public PiecethDTO createPieceth(@RequestBody PiecethDTO piecethDTO) {
        return piecethService.savePieceth(piecethDTO);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public PiecethDTO updatePieceth(@RequestBody PiecethDTO piecethDTO) {
        return piecethService.updatePieceth(piecethDTO);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletePieceth(@PathVariable("id") Long id) {
        piecethService.deletePiecethById(id);
    }
    
    @RequestMapping(value="/gen/{idGen}", method = RequestMethod.GET)
    public List<Pieceth> getPiecethsByGenreId(@PathVariable("idGen") Long idGen) {
        return piecethService.findByGenreId(idGen);
    }
}
