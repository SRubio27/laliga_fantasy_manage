package com.backend.miApiRest.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.miApiRest.models.CardModel;

@Repository
public interface CardRepository extends CrudRepository<CardModel, Long> {
    // Add custom query methods if needed
    public abstract ArrayList<CardModel> findByName(String name);
}
