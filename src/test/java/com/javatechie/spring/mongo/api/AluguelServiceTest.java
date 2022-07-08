package com.javatechie.spring.mongo.api;

import com.javatechie.spring.mongo.api.model.Livro;
import com.javatechie.spring.mongo.api.service.AluguelService;
import com.javatechie.spring.mongo.api.service.LivroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AluguelServiceTest {

    //testando somente quem realmente precisa
    //EX: os metódos com regras de negócio ou validações específicas

    @Autowired
    private AluguelService service;

    @Autowired
    private LivroService serviceLivro;

    @Test
    public void alugandoLivro() {
        Livro livro = new Livro(1L,"Harry Potter CS", "JK Holling", 300, "Aventura");
        serviceLivro.salvarLivro(livro);
        String mensagem = service.salvarLivroAlugadoOuDevolvido(livro, true);
        assertEquals("Livro Alugado com sucesso", mensagem);
    }
    @Test
    public void alugandoLivroAlugado() {
        Livro livro = new Livro(1L,"Harry Potter CS", "JK Holling", 300, "Aventura");
        serviceLivro.salvarLivro(livro);
        String mensagem = service.salvarLivroAlugadoOuDevolvido(livro, true);
        mensagem = service.salvarLivroAlugadoOuDevolvido(livro, true);
        assertEquals("O livro encontra-se alugado", mensagem);
    }
    @Test
    public void alugandoLivronaoExistente() {
        Livro livro = new Livro(1L,"Harry Potter CS", "JK Holling", 300, "Aventura");
        String mensagem = service.salvarLivroAlugadoOuDevolvido(livro, true);
        assertEquals("O livro encontra-se alugado", mensagem);
    }
    @Test
    public void devolvendoLivro() {
        Livro livro = new Livro(2L,"Harry Potter CS", "JK Holling", 300, "Aventura");
        String mensagem = service.salvarLivroAlugadoOuDevolvido(livro, false);
        assertEquals("Livro Devolvido com sucesso", mensagem);
    }

}
