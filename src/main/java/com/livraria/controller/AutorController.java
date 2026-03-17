package com.livraria.controller;

import com.livraria.model.Autor;
import com.livraria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepo;

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Autor autor){
        autorRepo.save(autor);
        return "redirect:/livros/form";
    }
}