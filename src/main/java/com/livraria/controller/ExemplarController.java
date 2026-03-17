package com.livraria.controller;

import com.livraria.model.LivroExemplar;
import com.livraria.model.Livro;
import com.livraria.repository.LivroExemplarRepository;
import com.livraria.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exemplares")
public class ExemplarController {

    @Autowired
    private LivroExemplarRepository exemplarRepo;

    @Autowired
    private LivroRepository livroRepo;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("exemplar", new LivroExemplar());
        model.addAttribute("livros", livroRepo.findAll());
        return "exemplares/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute LivroExemplar exemplar, Model model) {
        if (exemplarRepo.findByCod(exemplar.getCod()).isPresent()) {
            model.addAttribute("erro", "Já existe um exemplar com esse código!");
            model.addAttribute("livros", livroRepo.findAll());
            model.addAttribute("exemplar", exemplar); // importante! mantém os dados preenchidos
            return "exemplares/form";
        }

        exemplarRepo.save(exemplar);
        return "redirect:/exemplares/lista";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        List<LivroExemplar> exemplares = exemplarRepo.findAll();
        model.addAttribute("exemplares", exemplares);
        return "exemplares/lista";
    }
}