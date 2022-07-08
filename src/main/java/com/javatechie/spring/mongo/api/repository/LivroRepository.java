package com.javatechie.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.Livro;

public interface LivroRepository extends MongoRepository<Livro, Integer>{

}
