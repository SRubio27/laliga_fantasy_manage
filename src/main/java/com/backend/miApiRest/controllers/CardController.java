package com.backend.miApiRest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.miApiRest.models.CardModel;
import com.backend.miApiRest.services.CardService;


@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping()
    public ArrayList<CardModel> obtainUsers(){
        return cardService.obtainCards();
    }

    @GetMapping(path = "/{id}")
    public Optional<CardModel> obtainCardById(@PathVariable("id") Long id) {
        return this.cardService.obtainById(id);
    }

    @GetMapping(path = "/{name}")
    public ArrayList<CardModel> obtainCardByName(@PathVariable("name") String name){
        return this.cardService.obtainByName(name);
    }

    @PostMapping
    public CardModel saveCard(@RequestBody CardModel card){
        return this.cardService.saveCard(card);
    }

    
}