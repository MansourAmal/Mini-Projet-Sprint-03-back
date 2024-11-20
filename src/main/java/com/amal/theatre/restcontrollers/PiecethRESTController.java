package com.amal.theatre.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amal.theatre.entities.Pieceth;
import com.amal.theatre.service.PiecethService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PiecethRESTController {
    
    @Autowired
    PiecethService piecethService;

    @RequestMapping(path="all",method =RequestMethod.GET) 
    public List<Pieceth> getAllPieceths() {
        return piecethService.getAllPieceths();
    }
    
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public Pieceth getPiecethById(@PathVariable("id") Long id) {
        return piecethService.getPieceth(id);
    }
    
    @RequestMapping(path="/addprod",method = RequestMethod.POST)
    public Pieceth createPieceth(@RequestBody Pieceth pieceth) {
        return piecethService.savePieceth(pieceth);
    }
    
    @RequestMapping(path="/updateprod",method = RequestMethod.PUT)
    public Pieceth updatePieceth(@RequestBody Pieceth pieceth) {
        return piecethService.updatePieceth(pieceth);
    }
    
    @RequestMapping(value="/delprod/{id}",method = RequestMethod.DELETE) 
    public void deletePieceth(@PathVariable("id") Long id) {
        piecethService.deletePiecethById(id);
    }
    
    @RequestMapping(value="/gen/{idGen}", method = RequestMethod.GET)
    public List<Pieceth> getPiecethsByGenreId(@PathVariable("idGen") Long idGen) {
        return piecethService.findByGenreId(idGen);
    }
}
