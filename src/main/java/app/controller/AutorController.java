package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Autor;
import app.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Autor autor) {
		
		try {
			System.out.println(autor.getNome());
			String mensagem = this.autorService.save(autor);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Erro detectado", HttpStatus.BAD_REQUEST);
		}
	}
		
		@GetMapping("/findById/{id}")
		public ResponseEntity<Autor> findById(@PathVariable Long id){
			try {
					Autor autor = this.autorService.findById(id);
					return new ResponseEntity<>(autor, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
			
			@GetMapping("/listAll")
			public ResponseEntity<List<Autor>> listAll() {
				try {
						List<Autor> autor = this.autorService.listAll();
						return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				} catch(Exception e) {
					return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
				}
			}
				
			@PutMapping("/update/{id}")
			public ResponseEntity<String> update(@PathVariable long id, @RequestBody Autor autor){
				try {
						String mensagem = this.autorService.update(autor,id);
						return new ResponseEntity<>(mensagem, HttpStatus.OK);
				} catch(Exception e) {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}
			}
		}
