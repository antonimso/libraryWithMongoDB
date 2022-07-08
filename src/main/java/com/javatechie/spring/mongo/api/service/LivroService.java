package com.javatechie.spring.mongo.api.service;

import com.javatechie.spring.mongo.api.model.Livro;
import com.javatechie.spring.mongo.api.repository.LivroRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> findLivros() {
        return repository.findAll();
    }

    public Optional<Livro> procurarPorParametros(Long id, String nome, String autor) {
        Livro livro = new Livro(id, nome, autor);
        Example<Livro> example = Example.of(livro, ExampleMatcher.matchingAll().withIgnoreCase());
        return repository.findOne(example);
    }

    public void salvarLivro(Livro livro) {
        repository.save(livro);
    }

    public String editarLivro(Livro livro) {
        List<Livro> listaLivrosAlugados = repository.findByAlugadoTrue();
        if(!listaLivrosAlugados.isEmpty()){
            if(listaLivrosAlugados.contains(livro)){
                return "O livro encontra-se alugado, por gentileza edite após devolver";
            }
        }
        repository.save(livro);
        return "O livro foi editado com sucesso";
    }

    public String deleteById(int id) {
        Optional<Livro> livroAlugado = repository.findByAlugadoTrueById();
        if(livroAlugado.isPresent()){
            return "O livro encontra-se alugado, por gentileza delete após devolver";
        }
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Livro com o id " + id + " excluido com sucesso";
        }
        return "O livro com o Id informado não existe";
    }
}
