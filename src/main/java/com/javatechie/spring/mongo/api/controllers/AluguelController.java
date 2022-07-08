package com.javatechie.spring.mongo.api.controllers;

import com.javatechie.spring.mongo.api.model.Livro;
import com.javatechie.spring.mongo.api.service.AluguelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping("/findRentedBooks")
    public List<Livro> getLivrosAlugados() {
        return aluguelService.findLivrosAlugados();
    }

    //Alugando um livro informado
    @PostMapping("/addRentedBook")
    public String AlugandoLivro(@RequestBody Livro livro) {
        return aluguelService.salvarLivroAlugadoOuDevolvido(livro, true);
    }
    //Devolvendo um livro alugado
    @PostMapping("/removeRentedBook")
    public void DevolvendoLivro(@RequestBody Livro livro) {
        aluguelService.salvarLivroAlugadoOuDevolvido(livro, false);
    }

}
