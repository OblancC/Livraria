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

import app.entity.Livros;
import app.service.LivrosService;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    @Autowired
    private LivrosService livrosService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livros livros){
        try{
        	System.out.println(livros.getTitulo());
            String mensagem = this.livrosService.save(livros);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu ruim", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livros> findById(@PathVariable Long id){
        try{
            Livros livros = this.livrosService.findById(id);
            return new ResponseEntity<>(livros, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listAll")
    public ResponseEntity<List<Livros>> listAll(){
    	try {
    		List<Livros> lista = this.livrosService.listAll();
    		return new ResponseEntity<>(lista,HttpStatus.OK);
    		
    	}catch(Exception e){
    		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    	}
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Livros livros){
    	try {
    		String mensagem = this.livrosService.update(livros,id);
    		return new ResponseEntity<>(mensagem,HttpStatus.OK);
    		
    	}catch(Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	}
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
    	try {
    		String mensagem = this.livrosService.delete(id);
    		return new ResponseEntity<>(mensagem,HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    	}
    }
    
}
