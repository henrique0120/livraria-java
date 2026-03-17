package com.livraria.controller;

import com.livraria.model.Livro;
import com.livraria.model.Autor;
import com.livraria.model.Genero;
import com.livraria.repository.LivroRepository;
import com.livraria.repository.AutorRepository;
import com.livraria.repository.GeneroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepo;

    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private GeneroRepository generoRepo;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("autores", autorRepo.findAll());
        model.addAttribute("generos", generoRepo.findAll());
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro) {

        // Busca os objetos reais no banco
        if (livro.getAutor() != null && livro.getAutor().getId() != null) {
            Autor autor = autorRepo.findById(livro.getAutor().getId()).orElse(null);
            livro.setAutor(autor);
        }

        if (livro.getGenero() != null && livro.getGenero().getId() != null) {
            Genero genero = generoRepo.findById(livro.getGenero().getId()).orElse(null);
            livro.setGenero(genero);
        }

        livroRepo.save(livro);
        return "redirect:/livros/lista";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("livros", livroRepo.findAll());
        return "livros/lista";
    }
}