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
@RequestMapping("api/med")
public class MedicamentController {
	
	//@Autowired
	//MedService medService;
	
	@GetMapping("{id}")
	    public /*Med*/String getSuggestedMedicament(@PathVariable String id) {
	        System.out.println("listSuggestedMedicamentsId");
	        return "id med "+ "exists";//medService.list();
	    }
	
	
	
	
	  @GetMapping
	    public List</*Med*/String> listSuggestedMedicaments(@RequestParam Optional<String> search) {
	        System.out.println("listSuggestedMedicaments");
			if (search.isPresent()) {
	            //return medService.search(search.get());
	        }
	        return Arrays.asList(new String[]{"id med", "null"});//medService.list();
	    }

}
