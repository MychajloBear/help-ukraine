package de.ukrainewin.helpukraine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ukrainewin.helpukraine.model.Food;
import de.ukrainewin.helpukraine.repo.FoodRepo;

@Service
public class FoodService {

    private final FoodRepo foodRepo;
    //private final IdService idService;

    @Autowired
    public FoodService(FoodRepo FoodRepo//, IdService idService
    		) {
        this.FoodRepo = FoodRepo;
        //this.idService = idService;
    }

    public List<Food> list() {
        return FoodRepo.findAll();//getFoods();
    }
    public Food findById(String id) {
        Optional<Food> optionalFood = FoodRepo.findById(id);
        if (optionalFood.isPresent()) {
            return optionalFood.get();
        }
        throw new IllegalArgumentException("Id not found!");
    }

    public Food addFood(Food food) {
        Food.setId(null//idService.generateId()
        		);
        return FoodRepo.insert(Food);//add(Food);
    }

    public List<Food> search(String s) {
        List<Food> searchResultList = new ArrayList<>();
        for (Food Food: list()) {
            if (Food.getName().contains(s)){
                searchResultList.add(Food);
            }
        }

        return searchResultList;
    }

    public void delete(String id) {
        Food Food = findById(id);
        FoodRepo.delete(Food);
    }
}
