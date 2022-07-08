package com.javatechie.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.Livro;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface LivroRepository extends MongoRepository<Livro, Integer>, QueryByExampleExecutor<Livro> {

}
