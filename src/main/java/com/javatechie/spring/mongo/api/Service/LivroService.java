package com.javatechie.spring.mongo.api.Service;

import com.javatechie.spring.mongo.api.model.Livro;
import com.javatechie.spring.mongo.api.repository.LivroRepository;
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

    public Optional<Livro> findById(int id) {
        return repository.findById(id);
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
