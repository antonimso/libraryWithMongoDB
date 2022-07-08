package com.javatechie.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import com.javatechie.spring.mongo.api.Service.LivroService;
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

	@GetMapping("/findAllBooks/{id}")
	public Optional<Livro> getBook(@PathVariable int id) {
		return livroService.findById(id);
	}

	@PostMapping("/adicionarLivro")
	public void salvarLivro(@RequestBody Livro livro) {
		livroService.salvarLivro(livro);
	}

	@PostMapping("/editLivro")
	public String editarLivro(@RequestBody Livro livro) {
		livroService.editarLivro(livro);
		return "Livro editado com o id : " + livro.getId();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteLivro(@PathVariable int id) {
		return livroService.deleteById(id);
	}

}
