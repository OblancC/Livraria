package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
