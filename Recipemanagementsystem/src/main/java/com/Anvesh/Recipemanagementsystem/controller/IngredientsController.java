package com.Anvesh.Recipemanagementsystem.controller;


import com.Anvesh.Recipemanagementsystem.model.Ingredients;
import com.Anvesh.Recipemanagementsystem.service.IngredientsService;
import com.Anvesh.Recipemanagementsystem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //is an annotation used to define a class,,,
//@RestController, it combines the @Controller and @ResponseBody annotations. This means that all methods within the class are assumed to be returning data that should be serialized directly into the response body, making it convenient for building RESTful services.
public class IngredientsController {

    @Autowired
    IngredientsService iService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/ingredients")
    public ResponseEntity<String> createRecipe(@RequestBody List<Ingredients> ingredients, @RequestParam String email, @RequestParam String token) {
        HttpStatus status;
        String message;
        if (tokenService.authenticate(email, token)) {
            iService.createIngredients(ingredients, token);
            message = "Ingredients created successfully";
            status = HttpStatus.OK;
        } else {
            message = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(message, status);
    }
    @GetMapping("/ingredients")
    public ResponseEntity<String>  getIngredients(@RequestParam String token, @RequestParam String email) {

        if (tokenService.authenticate(email, token)) {
            List<Ingredients> i1 =  iService.getIngredients(email, token);
        }
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/ingredients")
    public ResponseEntity<String> deleteRecipe (@RequestParam Long id , @RequestParam String token , @RequestParam String email){
        HttpStatus status;
        String message;
        if (tokenService.authenticate(email, token)) {
            iService.deleteIngredients(id, token);
            message = "Ingredients removed successfully";
            status = HttpStatus.OK;
        } else {
            message = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(message, status);
    }
}
