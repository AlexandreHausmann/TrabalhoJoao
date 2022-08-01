package br.com.senior.TrabalhoJoao.dto;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import model.entity.Autor;

public class LivroDto {

	public String titulo;
	public String descricao;
	public BigDecimal preco;
	public LocalDate dataLancamento;
	public List<Autor> autores;
	public Book livraria;
}
