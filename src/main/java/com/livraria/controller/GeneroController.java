package com.livraria.controller;

import com.livraria.model.Genero;
import com.livraria.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepo;

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("genero", new Genero());
        return "generos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Genero genero){
        generoRepo.save(genero);
        return "redirect:/livros/form";
    }
}