package app.service;

import java.util.List;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import app.entity.Livros;
import app.repository.LivrosRepository;

@Service
public class LivrosService {

	@Resource
	private LivrosRepository livrosRepository;

	public String save(Livros livros){
		livrosRepository.save(livros);
		return "Livro Salvo";
	}

	public Livros findById(Long id){
		return livrosRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	}

	public List<Livros> listAll(){
		return livrosRepository.findAll();
	}

	public String delete(Long id) {
		livrosRepository.deleteById(id);
		return "Deletado Com Sucesso";
	}
	
	public String update(Livros livros, long id) {
		livros.setId(id);
		livrosRepository.save(livros);
		return "Alterado com Sucesso!";
	}
}
