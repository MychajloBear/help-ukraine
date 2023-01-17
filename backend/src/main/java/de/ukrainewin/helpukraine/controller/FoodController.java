package de.ukrainewin.helpukraine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.ukrainewin.helpukraine.model.Food;

@RestController
@RequestMapping("api/food")
public class FoodController {

	// @Autowired
	// FoodService foodService;

	@GetMapping
	public List</* Food */String> listFoods(@RequestParam Optional<String> search) {
		System.out.println("listSuggestedFoods");
		if (search.isPresent()) {
			// return foodService.search(search.get());
		}
		return Arrays.asList(new String[] { "id food", "null" });// foodService.list();
	}

	@GetMapping("{id}")
	public Food getFood(@PathVariable String id) {
		System.out.println("listSuggestedFoodsId");
		return new Food(id, "some name");// foodService.list();
	}

	@PostMapping()
	public String/* Food */ addFood(@RequestBody /* Food */String food) {
		return null;// foodService.addFood(food);
	}

	@DeleteMapping("{id}")
	public void deleteFood(@PathVariable String id) {
		// foodService.delete(id);
	}

}
