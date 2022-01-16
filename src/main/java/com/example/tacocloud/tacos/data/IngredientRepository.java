package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.Ingredient;

public interface IngredientRepository
{
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
