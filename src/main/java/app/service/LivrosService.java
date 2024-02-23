package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livros;
import app.repository.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;

	public String save(Livros livros){
		this.livrosRepository.save(livros);
		return "Livro Salvo";
	}

	public Livros findById(Long id){
		Optional<Livros> livros = this.livrosRepository.findById(id);
		return livros.get();
	}

	public List<Livros> listAll(){
		List<Livros> livros = this.livrosRepository.findAll();
		return livros;
	}

	public String delete(Long id) {
		this.livrosRepository.deleteById(id);	
		return "Deletado Com Sucesso";
	}
	
	public String update(Livros livros, long id) {
		livros.setId(id);
		this.livrosRepository.save(livros);
		return "Alterado com Sucesso!";
	}
}
