package com.javatechie.spring.mongo.api.Service;

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

    public Optional<Livro> findPerParameters(Long id, String nome, String autor) {
        Livro livro = new Livro(id, nome, autor);
        Example<Livro> example = Example.of(livro, ExampleMatcher.matchingAll().withIgnoreCase());
        return repository.findOne(example);
    }

    public void salvarLivro(Livro livro) {
        repository.save(livro);
    }

    public void editarLivro(Livro livro) {
        repository.save(livro);
    }

    public String deleteById(int id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Livro com o id " + id + " excluido com sucesso";
        }
        return "O livro com o Id informado não existe";
    }
}
