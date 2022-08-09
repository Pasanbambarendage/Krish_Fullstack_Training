package com.example.FuelSchedule.repository;

import com.example.FuelSchedule.model.FuelSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelScheduleRepo extends MongoRepository<FuelSchedule,Integer> {
}
