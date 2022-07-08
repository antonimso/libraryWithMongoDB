package com.javatechie.spring.mongo.api;

import com.javatechie.spring.mongo.api.model.Livro;
import com.javatechie.spring.mongo.api.service.LivroService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivroServiceTest {

    //testando somente quem realmente precisa
    //EX: os metódos com regras de negócio ou validações específicas

    @Autowired
    private LivroService service;

    @BeforeEach
    public void setup(){
        Livro livro = new Livro(1L,"Harry Potter", "JK Holling", 300, "Aventura");
        service.salvarLivro(livro);
    }
    
    @Test
    public void buscaPorParametrosPeloId() {
        Optional<Livro> livroBuscado = service.procurarPorParametros(1L, "Harry", "JK");
        assertTrue(livroBuscado.isPresent());
        assertEquals(new Livro(1L, "Harry Potter", "JK Holling"), livroBuscado.get());
    }
    @Test
    public void buscaPorParametrosPeloNome() {
        Optional<Livro> livroBuscado = service.procurarPorParametros(3L, "Harry Potter", "Hl");
        assertTrue(livroBuscado.isPresent());
        assertEquals(new Livro(1L, "Harry Potter", "JK Holling"), livroBuscado.get());
    }
    @Test
    public void buscaPorParametrosPeloAutor() {
        Optional<Livro> livroBuscado = service.procurarPorParametros(3L, "Potter", "JK Holling");
        assertTrue(livroBuscado.isPresent());
        assertEquals(new Livro(1L, "Harry Potter", "JK Holling"), livroBuscado.get());
    }
    @Test
    public void editandoLivroComSucesso() {
        Livro livro = new Livro(2L,"Harry Potter CS", "JK Holling", 300, "Aventura");
        String mensagem = service.editarLivro(livro);
        assertEquals("O livro foi editado com sucesso", mensagem);
    }

    @Test
    public void deletandoLivroComIdNaoExistente() {
        Livro livro = new Livro(2L,"Harry Potter CS", "JK Holling", 300, "Aventura");
        String mensagem = service.deleteById(4);
        assertEquals("O livro com o Id informado não existe", mensagem);
    }
    
    
}
