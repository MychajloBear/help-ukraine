package de.ukrainewin.helpukraine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/flat")
public class FlatController {
	
	//@Autowired
	//FlatService flatService;
	
	@GetMapping("{id}")
	    public /*Flat*/String getSuggestedFlat(@PathVariable String id) {
	        System.out.println("listSuggestedFlatWithId");
	        return "id flat "+ "exists";//flatService.list();
	    }
	
	  @GetMapping
	    public List</*Flat*/String> listSuggestedFlats(@RequestParam Optional<String> search) {
	        System.out.println("listSuggestedFlats");
			if (search.isPresent()) {
	            //return flatService.search(search.get());
	        }
	        return Arrays.asList(new String[]{"id flat", "null"});//flatService.list();
	    }

}
