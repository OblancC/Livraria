package app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import app.entity.Biblioteca;
import app.entity.Livros;
import app.repository.LivrosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class LivrosServiceTest {

    @Test
    void testSave() {
        Livros livro = new Livros();

        String saved = livrosService.save(livro);

        verify(repository, times(1)).save(livro);
        assertEquals("Livro Salvo", saved);
    }

    @Test
    void findById(){
        Livros value = new Livros();
        value.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(value));

        Livros byId = livrosService.findById(1L);

        assertEquals(1L, byId.getId());
        assertEquals(value, byId);
        assertNotNull(byId);
    }

    @Test
    void findByIDException(){
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            livrosService.findById(1L);
        });
    }


    @Mock
    private LivrosRepository repository;

    @InjectMocks
    private LivrosService livrosService;
}