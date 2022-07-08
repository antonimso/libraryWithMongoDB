package com.javatechie.spring.mongo.api.service;

import com.javatechie.spring.mongo.api.model.Livro;
import com.javatechie.spring.mongo.api.repository.LivroRepository;

import java.util.List;

public class AluguelService {

    private final LivroRepository repository;

    public AluguelService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> findLivrosAlugados() {
        return repository.findByAlugadoTrue();
    }

    public String salvarLivroAlugadoOuDevolvido(Livro livro, boolean b) {
        if(b){
            return salvarLivroAlugado(livro);
        }
        else{
           return salvarLivroDevolvido(livro);
        }
    }

    private String salvarLivroAlugado(Livro livro) {
        List<Livro> listaLivrosAlugados = findLivrosAlugados();
        if(listaLivrosAlugados.isEmpty()){
            livro.setAlugado(true);
            repository.save(livro);
            return "Livro Alugado com sucesso";
        }
        if(listaLivrosAlugados.contains(livro)){
            return "O livro encontra-se alugado";
        }
        return "Livro não encontrado";
    }

    private String salvarLivroDevolvido(Livro livro) {
        livro.setAlugado(false);
        repository.save(livro);
        return "Livro Devolvido com sucesso";
    }
}
