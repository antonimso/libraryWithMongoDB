package com.javatechie.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
public class Livro {
	@Id
	private int id;

	private String nome;
	private String autor;
	private int qtdPaginas;
	private String genero;

	public Livro() {
	}

	public Livro(int id, String nome, String autor, int qtdPaginas, String genero) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.qtdPaginas = qtdPaginas;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", autor='" + autor + '\'' +
				", qtdPaginas=" + qtdPaginas +
				", genero='" + genero + '\'' +
				'}';
	}
}
