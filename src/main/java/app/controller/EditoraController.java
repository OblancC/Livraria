package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Editora;
import app.service.EditoraService;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {
	
	@Autowired
	private EditoraService editoraService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Editora editora)  {
		
		try {
			System.out.println(editora.getNome());
			String mensagem = this.editoraService.save(editora);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Erro detectado", HttpStatus.BAD_REQUEST);
		}
	}
		
		@GetMapping("/findById/{id}")
		public ResponseEntity<Editora> findById(@PathVariable Long id) {
			try {
					Editora editora = this.editoraService.findById(id);
					return new ResponseEntity<>(editora,HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
			
		@GetMapping("/listAll")
		public ResponseEntity<List<Editora>> listAll(){
				try {
						List<Editora> lista = this.editoraService.listAll();
						return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}catch (Exception e) {
				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
		}
			
		@PutMapping("/update/{id}")
		public ResponseEntity<String> update(@PathVariable long id, @RequestBody Editora editora){
			try {
					String mensagem = this.editoraService.update(editora,id);
					return new ResponseEntity<>(mensagem, HttpStatus.OK);
			} catch(Exception e) {
					return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
		}
			
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable long id) {
			try {
				String mensagem = this.editoraService.delete(id);
				return new ResponseEntity<>(mensagem, HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
		}
}
