package app.controller;

import java.util.List;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LivrosController {

    @Resource
    private LivrosService livrosService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livros livros){
        try{
            log.info(livros.getTitulo());
            String mensagem = livrosService.save(livros);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Livros livros = livrosService.findById(id);
            return new ResponseEntity<>(livros, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listAll")
    public ResponseEntity<?> listAll(){
    	try {
    		List<Livros> lista = livrosService.listAll();
    		return new ResponseEntity<>(lista, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
    	}
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Livros livros){
    	try {
    		String mensagem = livrosService.update(livros,id);
    		return new ResponseEntity<>(mensagem, HttpStatus.OK);
    		
    	}catch(Exception e) {
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
    	try {
    		String mensagem = livrosService.delete(id);
    		return new ResponseEntity<>(mensagem, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	}
    }
    
}
