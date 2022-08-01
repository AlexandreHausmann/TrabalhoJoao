package br.com.senior.TrabalhoJoao.mapper;
import org.springframework.stereotype.Service;
import br.com.senior.TrabalhoJoao.dto.AutorDto;
import model.entity.Autor;

@Service
public class AutorMapper {
	public AutorDto toDto(Autor autor) {
		AutorDto dto = new AutorDto();
		
		dto.nome = autor.getNome();
		dto.sexo = autor.getSexo();		
		dto.livros = autor.getLivros();
		
		return dto;
	}
	
	public Autor toEntity(AutorDto dto) {
		Autor autor = new Autor();
		
		autor.setNome(dto.nome);
		autor.setSexo(dto.sexo);
		autor.setLivros(dto.livros);
		
		return autor;
	}
}