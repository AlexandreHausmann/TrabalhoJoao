package br.com.senior.TrabalhoJoao.repository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID>{

		Optional<Livro> findLivrosByIdLivro(UUID idLivro);
		boolean existsByIdLivro(UUID idLivro);
		Boolean deleteLivroByIdLivro(UUID idLivro);
		
	}