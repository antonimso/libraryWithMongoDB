package com.javatechie.spring.mongo.api.controllers;

import java.util.List;
import java.util.Optional;

import com.javatechie.spring.mongo.api.service.LivroService;
import org.springframework.web.bind.annotation.*;

import com.javatechie.spring.mongo.api.model.Livro;

@RestController
@RequestMapping("/livro")
public class LivroController {

	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@GetMapping("/findAllBooks")
	public List<Livro> getLivros() {
		return livroService.findLivros();
	}

	@GetMapping("/findWithParams")
	public Optional<Livro> getLivroPorParametro(@RequestParam(required = false) Long id,
												@RequestParam(required = false) String nome,
												@RequestParam(required = false) String autor) {
		return livroService.procurarPorParametros(id, nome, autor);
	}

	@PostMapping("/addBook")
	public void salvarLivro(@RequestBody Livro livro) {
		livroService.salvarLivro(livro);
	}

	@PostMapping("/editBook")
	public String editarLivro(@RequestBody Livro livro) {
		return livroService.editarLivro(livro);
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteLivro(@PathVariable int id) {
		return livroService.deleteById(id);
	}

}
