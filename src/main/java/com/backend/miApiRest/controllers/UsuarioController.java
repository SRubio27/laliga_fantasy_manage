package com.backend.miApiRest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.miApiRest.models.UserModel;
import com.backend.miApiRest.services.UsuarioService;



@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired //instanciar por Spring
    private UsuarioService userService;

    @GetMapping()
    public ArrayList<UserModel> obtainUsers(){
        return userService.obtainUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> obtainUserById(@PathVariable("id") Long id){
        return this.userService.obtainById(id);
    }
    
    @GetMapping("/query")
    public ArrayList<UserModel> obtainUserForName(@RequestParam("name") String name) {
        return this.userService.obtainByName(name);
    }

    @PostMapping //Devuelve el user
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean status = this.userService.deleteUserById(id);
        if (status != true) {
            return "User with id " + id + " could not be deleted.";
        }
        
        return "User with id " + id + "  has been deleted.";
    }

}