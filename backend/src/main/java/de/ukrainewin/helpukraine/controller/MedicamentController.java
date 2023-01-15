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
	//FoodService foodService;
	
	@GetMapping("{id}")
	    public List</*Food*/String> listSuggestedMedicamentsId(@PathVariable String id) {
	        System.out.println("listSuggestedMedicamentsId");
	        return List.of("id med", "exists");//foodService.list();
	    }
	
	
	
	
	  @GetMapping
	    public List</*Food*/String> listSuggestedMedicaments(@RequestParam Optional<String> search) {
	        System.out.println("listSuggestedMedicaments");
			if (search.isPresent()) {
	            //return foodService.search(search.get());
	        }
	        return Arrays.asList(new String[]{"id med", "null"});//foodService.list();
	    }

}
