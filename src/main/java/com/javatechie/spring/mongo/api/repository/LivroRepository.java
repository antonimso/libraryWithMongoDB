package com.javatechie.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.Livro;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends MongoRepository<Livro, Integer>, QueryByExampleExecutor<Livro> {

    List<Livro> findByAlugadoTrue();

    Optional<Livro> findByAlugadoTrueById();
}
