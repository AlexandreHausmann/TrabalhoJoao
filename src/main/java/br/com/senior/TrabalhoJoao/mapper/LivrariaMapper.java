package br.com.senior.TrabalhoJoao.mapper;
import org.springframework.stereotype.Service;
import br.com.senior.TrabalhoJoao.dto.LivrariaDto;
import model.entity.Livraria;

@Service
public class LivrariaMapper {
	
	
	public LivrariaDto toDto(Livraria livraria) {
		LivrariaDto dto = new LivrariaDto();
		
		dto.nome = livraria.getNome();
		dto.email = livraria.getEmail();
		dto.telefone = livraria.getTelefone();
		dto.cnpj = livraria.getCnpj();
		dto.book = livraria.getBook();
		
		return dto;
		
	}
	
	public Livraria toEntity(LivrariaDto dto) {
		Livraria livraria = new Livraria();
		
		livraria.setNome(dto.nome);
		livraria.setEmail(dto.email);
		livraria.setTelefone(dto.telefone);
		livraria.setCnpj(dto.cnpj);
		livraria.setBook(dto.book);
		
		return livraria;
	}
	
}
