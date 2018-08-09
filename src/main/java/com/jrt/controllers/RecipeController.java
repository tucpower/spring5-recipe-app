package com.jrt.controllers;

import com.jrt.domain.Recipe;
import com.jrt.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @GetMapping
    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {

        model.addAttribute("recipe", new Recipe());

        return "recipe/recipeForm";
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/recipeForm";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute Recipe recipe) {

        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        return "redirect:/recipe/" + savedRecipe.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {

        System.out.println("Deleting id: " + id);

        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/";
    }
}
