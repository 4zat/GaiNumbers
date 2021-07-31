package com.example.GaiNumbers.controllers;

import com.example.GaiNumbers.generate.NumberGenerate;
import com.example.GaiNumbers.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class NumberController {

    NumberGenerate numberGenerate = new NumberGenerate();

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }


    @GetMapping("/all")
    List<String> findAllByNumbers() {
        return numberService.findAllByNumbers();
    }

    @GetMapping("/random")
    String random(Model model) {
        numberService.insertNumbers_value(numberGenerate.rand(numberService.findAllByNumbers()));
        model.addAttribute("name", numberService.findLast());
        return "greeting";
    }

    @GetMapping("/next")
    String next(Model model) {
        numberService.insertNumbers_value(numberGenerate.nextNumber(numberService.findLast()));
        model.addAttribute("name", numberService.findLast());
        return "greeting";
    }


}
