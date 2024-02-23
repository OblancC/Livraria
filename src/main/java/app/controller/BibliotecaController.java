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

import app.entity.Biblioteca;
import app.service.BibliotecaService;

@RestController
@RequestMapping("/library")
public class BibliotecaController {
	@Autowired
	private BibliotecaService bibliotecaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca){
		try {
			System.out.println(biblioteca.getNome());
			String mensagem = this.bibliotecaService.save(biblioteca);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> ("Deu problema", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Biblioteca> findById(@PathVariable Long id){
		try {
			Biblioteca biblioteca = this.bibliotecaService.findById(id);
			return new ResponseEntity<>(biblioteca,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Biblioteca>> listAll(){
		try {
			List<Biblioteca> lista = this.bibliotecaService.listAll();
			return new ResponseEntity<>(lista,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Biblioteca biblioteca){
		try {
			String mensagem = this.bibliotecaService.update(biblioteca,id);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.bibliotecaService.delete(id);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

}
