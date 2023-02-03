package de.ukrainewin.helpukraine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.ukrainewin.helpukraine.model.Food;
import de.ukrainewin.helpukraine.model.FoodDTO;
import de.ukrainewin.helpukraine.service.FoodService;

@RestController
@RequestMapping("api/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	@GetMapping
	public List<Food> listFoods(@RequestParam Optional<String> search) {
		if (search.isPresent()) {
			return foodService.search(search.get());
		}
		return foodService.list();
	}

	@GetMapping("{id}")
	public Food getFood(@PathVariable String id) {
		return foodService.findById(id);
	}

}
