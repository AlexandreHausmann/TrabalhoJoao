package br.com.senior.TrabalhoJoao.mapper;
import org.springframework.stereotype.Service;
import br.com.senior.TrabalhoJoao.dto.LivroDto;
import model.entity.Livro;

@Service
public class LivroMapper {
	
	public LivroDto toDto (Livro livro) {
		LivroDto dto = new LivroDto();
		
		dto.titulo = livro.getTitulo();
		dto.descricao = livro.getDescricao();
		dto.preco = livro.getPreco();
		dto.dataLancamento = livro.getDataLancamento();
		dto.autores = livro.getAutores();
		dto.livraria =livro.getLivraria();
		
		return dto;
	}
	
	public Livro toEntity(LivroDto dto) {
		Livro livro = new Livro();
		
		livro.setTitulo(dto.titulo);
		livro.setDescricao(dto.descricao);
		livro.setPreco(dto.preco);
		livro.setDataLancamento(dto.dataLancamento);
		livro.setAutores(dto.autores);
		livro.setLivraria(dto.livraria);
		
		return livro;
		
	}
}