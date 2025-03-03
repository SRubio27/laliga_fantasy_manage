package com.backend.miApiRest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.miApiRest.models.CardModel;
import com.backend.miApiRest.repositories.CardRepository;

@Service
public class CardService {
    @Autowired
    CardRepository CardRepository;
    
    public ArrayList <CardModel> obtainCards() {
        return (ArrayList<CardModel>) CardRepository.findAll();
    }

    public Optional <CardModel> obtainById(Long id){
        return CardRepository.findById(id);
    }

    public ArrayList <CardModel> obtainByName(String name) {
        return CardRepository.findByName(name);
    }

    public CardModel saveCard(CardModel card) {
        return CardRepository.save(card);
    }

}