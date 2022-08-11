package com.example.FuelDispatch.repository;

import com.example.FuelDispatch.model.FuelDispatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelDispatchRepo extends MongoRepository <FuelDispatch ,Integer> {
}
