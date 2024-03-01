package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ano;
    private int numeropagina;
    private String issn;
    private String sinopse;
    private String titulo;	
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("livros")
    private Biblioteca biblioteca;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "livro_autor")
    private List<Autor> autor;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("livros")
    private Editora editora;
}