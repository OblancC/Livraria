package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;
@Service
public class BibliotecaService {

	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	public String save(Biblioteca biblioteca) {
		this.bibliotecaRepository.save(biblioteca);
		return "Livro Salvo";
	}
	
	public Biblioteca findById(Long id) {
		Optional<Biblioteca> biblioteca = this.bibliotecaRepository.findById(id);
		return biblioteca.get();
	}
	
	public List<Biblioteca> listAll(){
		List<Biblioteca> biblioteca = this.bibliotecaRepository.findAll();
		return biblioteca;
	}
	
	public String delete(Long id) {
		this.bibliotecaRepository.deleteById(id);
		return "Deletado Com Sucesso"; 
	}
	
	public String update(Biblioteca biblioteca, long id) {
		biblioteca.setId(id);
		this.bibliotecaRepository.save(biblioteca);
		return "Alterado com Sucesso!";
	}
}
