package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.repository.AutorRepository;


@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public String save(Autor autor) {
		this.autorRepository.save(autor);
		return "Autor salvo com sucesso!";
	}
	
	public Autor findById(Long id) {
		Optional<Autor> autor = this.autorRepository.findById(id);
		return autor.get();
	}
	
	public List<Autor> listAll() {
		List<Autor> autor = this.autorRepository.findAll();
		return autor;
	}
	
	public String delete(Long id) {
		this.autorRepository.deleteById(id);
		return "Item deletado com sucesso!";
	}
	
	public String update(Autor autor, long id) {
		autor.setId(id);
		this.autorRepository.save(autor);
		return "Item atualizado com sucesso!";
	}

}
