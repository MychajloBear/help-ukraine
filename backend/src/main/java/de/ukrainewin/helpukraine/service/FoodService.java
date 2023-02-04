package de.ukrainewin.helpukraine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ukrainewin.helpukraine.model.Food;
import de.ukrainewin.helpukraine.model.FoodDTO;
import de.ukrainewin.helpukraine.repo.FoodRepo;

@Service
public class FoodService {

	private final FoodRepo foodRepo;
	private final IdService idService;

	public FoodService(FoodRepo foodRepo, IdService idService) {
		this.foodRepo = foodRepo;
		this.idService = idService;
	}

	public List<Food> list() {
		return foodRepo.findAll();
	}

	public Food findById(String id) {
		Optional<Food> optionalFood = foodRepo.findById(id);
		if (optionalFood.isPresent()) {
			return optionalFood.get();
		}
		throw new IllegalArgumentException("Food with Id " + id + " not found!");
	}

	public Food addFood(FoodDTO food) {
		Food newFood = new Food(idService.generateId(), food.name());
		return foodRepo.insert(newFood);
	}

	public List<Food> search(String s) {
		List<Food> searchResultList = new ArrayList<>();
		for (Food food : list()) {
			if (food.getName().contains(s)) {
				searchResultList.add(food);
			}
		}
		return searchResultList;
	}

	public void delete(String id) {
		foodRepo.deleteById(id);
	}
}
