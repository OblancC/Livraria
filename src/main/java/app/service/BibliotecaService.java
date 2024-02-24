package app.service;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;

@Service
public class BibliotecaService {

	@Resource
	private BibliotecaRepository bibliotecaRepository;
	
	public String save(Biblioteca biblioteca) {
		bibliotecaRepository.save(biblioteca);
		return "Salvo com Sucesso!";
	}
	
	public Biblioteca findById(Long id) {
		return bibliotecaRepository.findById(id).orElseThrow(() -> new RuntimeException("Biblioteca não encontrada"));
	}
	
	public List<Biblioteca> listAll(){
		return bibliotecaRepository.findAll();
	}
	
	public String delete(Long id) {
		bibliotecaRepository.deleteById(id);
		return "Deletado Com Sucesso";
	}
	
	public String update(Biblioteca biblioteca, long id) {
		biblioteca.setId(id);
		bibliotecaRepository.save(biblioteca);
		return "Alterado com Sucesso!";
	}
}
