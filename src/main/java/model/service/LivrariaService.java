package model.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senior.TrabalhoJoao.repository.LivrariaRepository;
import model.entity.Livraria;
import model.exception.AutorNotFoundExcption;
import model.exception.LivrariaNotFoundExcption;

@Service
public class LivrariaService {
	@Autowired
	private LivrariaRepository repository;

	public List<Livraria> getAllLivraria() {
		Optional<List<Livraria>> livraria = Optional.of(repository.findAll());
		if (livraria.isPresent()) {
			return livraria.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new AutorNotFoundExcption("Livraria não encontrado");
	}

	public Livraria getLivraria(UUID idLivraria) {
		Optional<Livraria> livraria = repository.findLivrosByIdLivraria(idLivraria);
		if (livraria.isPresent()) {
			return livraria.get();
		}
		throw new AutorNotFoundExcption("Livraria não encontrado");
	}

	public Livraria saveLivraria(Livraria livraria) {
		return repository.save(livraria);
	}

	public Livraria updateautor(UUID idLivraria, Livraria livraria) {
		Livraria oldLivraria = this.getLivraria(idLivraria);
		oldLivraria.setNome(livraria.getNome());
		oldLivraria.setEmail(livraria.getEmail());
		oldLivraria.setTelefone(livraria.getTelefone());
		oldLivraria.setCnpj(livraria.getCnpj());
		oldLivraria.setBook(livraria.getBook());

		return this.saveLivraria(oldLivraria);
	}

	public Boolean deleteLivraria(UUID idLivraria) {
		if (!repository.existsByIdLivraria(idLivraria)) {
			throw new LivrariaNotFoundExcption("Livraria não encontrado");
		}
		Boolean canDelete = repository.deleteLivrariaByIdLivraria(idLivraria);
		return canDelete;
	}
}