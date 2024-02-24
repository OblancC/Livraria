package app.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editora {
	@Id
	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	
}
