package com.Anvesh.Recipemanagementsystem.service;

import com.Anvesh.Recipemanagementsystem.model.AuthenticationToken;
import com.Anvesh.Recipemanagementsystem.model.Ingredients;
import com.Anvesh.Recipemanagementsystem.repository.IIngredientsRepo;
import com.Anvesh.Recipemanagementsystem.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    @Autowired
    IIngredientsRepo iRepo;


    @Autowired
    ITokenRepo tokenRepo;
    public void createIngredients(List<Ingredients> ingredients, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.saveAll(ingredients);
        }
    }

    public List<Ingredients> getIngredients(String email, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        return iRepo.findAll();
    }

    public void deleteIngredients(Long id, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.deleteById(id);
        }
    }
}

