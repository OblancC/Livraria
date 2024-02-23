package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
