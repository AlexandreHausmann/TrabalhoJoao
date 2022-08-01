package br.com.senior.TrabalhoJoao.repository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {
	
		Optional<Autor> findAutorByIdAutor(UUID idAutor);
		boolean existsByIdAutor(UUID idAutor);
		Boolean deleteAutorByIdAutor(UUID idAutor);
		Autor saveAll(Autor autor);

		
	}