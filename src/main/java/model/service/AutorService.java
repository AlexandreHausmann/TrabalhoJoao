package model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senior.TrabalhoJoao.repository.AutorRepository;
import model.entity.Autor;
import model.exception.AutorNotFoundExcption;

@Service
public class AutorService {
	@Autowired
	private AutorRepository repository;

	public List<Autor> getAllAutor() {
		Optional<List<Autor>> autor = Optional.of(repository.findAll());
		if (autor.isPresent()) {
			return autor.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new AutorNotFoundExcption("Autor não encontrado");
	}

	public Autor getAutor(UUID idAutor) {
		Optional<Autor> autor = repository.findAutorByIdAutor(idAutor);
		if (autor.isPresent()) {
			return autor.get();
		}
		throw new AutorNotFoundExcption("Autor não encontrado");
	}

	public Autor saveAutor(Autor autor) {
		return repository.saveAll(autor);
	}

	public Autor updateautor(UUID idAutor, Autor autor) {
		Autor oldAutor = this.getAutor(idAutor);
		oldAutor.setNome(autor.getNome());
		oldAutor.setSexo(autor.getSexo());
		oldAutor.setLivros(autor.getLivros());
		return this.saveAutor(oldAutor);
	}

	public Boolean deleteAutor(UUID idAutor) {
		if (!repository.existsByIdAutor(idAutor)) {
			throw new AutorNotFoundExcption("Autor não encontrado");
		}
		Boolean canDelete = repository.deleteAutorByIdAutor(idAutor);
		return canDelete;
	}
}