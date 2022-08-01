package model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senior.TrabalhoJoao.repository.LivroRepository;
import model.entity.Livro;
import model.exception.AutorNotFoundExcption;
import model.exception.LivroNotFoundExcption;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;

	public List<Livro> getAllLivro() {
		Optional<List<Livro>> livro = Optional.of(repository.findAll());
		if (livro.isPresent()) {
			return livro.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new AutorNotFoundExcption("Livro não encontrado");
	}

	public Livro getLivro(UUID idLivro) {
		Optional<Livro> livro = repository.findLivrosByIdLivro(idLivro);
		if (livro.isPresent()) {
			return livro.get();
		}
		throw new AutorNotFoundExcption("Livro não encontrado");
	}

	public Livro saveLivro(Livro livro) {
		return repository.save(livro);
	}

	public Livro updateLivro(UUID idLivro, Livro livro) {
		Livro oldLivro = this.getLivro(idLivro);
		oldLivro.setTitulo(livro.getTitulo());
		oldLivro.setDescricao(livro.getDescricao());
		oldLivro.setPreco(livro.getPreco());
		oldLivro.setDataLancamento(livro.getDataLancamento());
		oldLivro.setLivraria(livro.getLivraria());
		oldLivro.setAutores(livro.getAutores());

		return this.saveLivro(oldLivro);
	}

	public Boolean deleteLivraria(UUID idLivro) {
		if (!repository.existsByIdLivro(idLivro)) {
			throw new LivroNotFoundExcption("Livro não encontrado");
		}
		Boolean canDelete = repository.deleteLivroByIdLivro(idLivro);
		return canDelete;
	}
}
