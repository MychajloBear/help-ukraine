package de.ukrainewin.helpukraine.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.ukrainewin.helpukraine.model.Food;

@Repository
public interface FoodRepo extends MongoRepository<Food, String> {

}
