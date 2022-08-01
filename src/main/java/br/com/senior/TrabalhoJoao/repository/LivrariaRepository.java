package br.com.senior.TrabalhoJoao.repository;
import org.springframework.stereotype.Repository;
import model.entity.Livraria;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LivrariaRepository extends JpaRepository<Livraria, UUID>{
	
	Optional<Livraria> findLivrosByIdLivraria(UUID idLivraria);
	boolean existsByIdLivraria(UUID idLivraria);
	Boolean deleteLivrariaByIdLivraria(UUID idLivraria);
}