package com.example.tacocloud.tacos.web;

import com.example.tacocloud.tacos.Ingredient;
import com.example.tacocloud.tacos.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController
{
    @GetMapping
    public String showDesignForm(Model model)
    {
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ingredients.add(new Ingredient("WRAP" + i, "WRAP INGREDIENT" + i, Ingredient.Type.WRAP));
            ingredients.add(new Ingredient("CHEES" + i, "CHEES INGREDIENT" + i, Ingredient.Type.CHEES));
            ingredients.add(new Ingredient("PROTEIN" + i, "PROTEIN INGREDIENT" + i, Ingredient.Type.PROTEIN));
            ingredients.add(new Ingredient("SAUCE" + i, "SAUCE INGREDIENT" + i, Ingredient.Type.SAUCE));
            ingredients.add(new Ingredient("VEGGIES" + i, "VEGGIES INGREDIENT" + i, Ingredient.Type.VEGGIES));
        }
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types)
        {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("taco", new Taco());

        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type)
    {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "design";
        }

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }
}
