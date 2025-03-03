package com.backend.miApiRest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.miApiRest.models.UserModel;
import com.backend.miApiRest.repositories.UserRepository;


@Service
public class UsuarioService {
    @Autowired
    UserRepository UsuarioRepository;

    public ArrayList<UserModel> obtainUsers() {
        return (ArrayList<UserModel>) UsuarioRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return UsuarioRepository.save(user);
    }

    public Optional<UserModel> obtainById(Long id) {
        return UsuarioRepository.findById(id);
    }

    public ArrayList <UserModel> obtainByName(String name) {
        return UsuarioRepository.findByName(name);
    }

    public boolean deleteUserById(Long id) {
        try {
            UsuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }


}