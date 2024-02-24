package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Editora;
import app.repository.EditoraRepository;

@Service
public class EditoraService {
	
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	public String save(Editora editora) {
		this.editoraRepository.save(editora);
		return "Editora salva com sucesso!";
	}
	
	public Editora findById(Long id) {
		Optional<Editora> editora = this.editoraRepository.findById(id);
		return editora.get();
	}
	
	public List<Editora> listAll(){
		List<Editora> editora = this.editoraRepository.findAll();
		return editora;
	}
	
	public String delete(Long id) {
		this.editoraRepository.deleteById(id);
		return "Item deletado com sucesso";
	}
	
	public String update(Editora editora, long id) {
		editora.setId(id);
		this.editoraRepository.save(editora);
		return "Item atualizado com sucesso!";
	}
}
