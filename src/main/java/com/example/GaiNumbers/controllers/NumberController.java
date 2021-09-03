package com.example.GaiNumbers.controllers;

import com.example.GaiNumbers.generate.NumberGenerate;
import com.example.GaiNumbers.service.NumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class NumberController {

    NumberGenerate numberGenerate = new NumberGenerate();

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }


    @GetMapping("/random")
    String random(Model model) {
        String num = numberGenerate.rand(numberService.findAllByNumbers());

        numberService.insertNumbersValue(numberGenerate.generateId(numberService.findAllByNumberId(),
                        numberService.findByLastId()),num);

        model.addAttribute("name", num);
        return "greeting";
    }

    @GetMapping("/next")
    String next(Model model, HttpSession session) {
        String num = "";

        if (session.getAttribute("test") == null) {
            session.setAttribute("test", numberService.findLast());
        }

        num = numberGenerate.checkFindLast(numberGenerate.nextNumber((String) session.getAttribute("test"),
                        numberService.findAllByNumbers()),
                numberService.findAllByNumbers());

        numberService.insertNumbersValue(numberGenerate.generateId(numberService.findAllByNumberId(),
                numberService.findByLastId()), num);

        model.addAttribute("name", num);
        return "greeting";
    }

    @PostMapping("/next")
    String postNext(@RequestParam(name = "test", defaultValue = "Error") String test, HttpSession session) {
        session.setAttribute("test", test);
        return "redirect:/next";
    }

    @GetMapping("/test")
    void test() {
        for (int i = 0; i < 991; i++) {

        String num = numberGenerate.checkFindLast(numberGenerate.nextNumber(numberService.findLast(),
                        numberService.findAllByNumbers()),
                numberService.findAllByNumbers());

        numberService.insertNumbersValue(numberGenerate.generateId(numberService.findAllByNumberId(),
                numberService.findByLastId()), num);
        }
    }

}
