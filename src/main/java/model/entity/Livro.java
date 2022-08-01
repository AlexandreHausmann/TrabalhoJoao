package model.entity;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "LivroEntity")
@Table(name = "livroEntity")
public class Livro {
	
	
	@Id
	private UUID idLivro;
	
	@Column
	private String titulo;
	
	@Column
	private String descricao;
	
	@Column
	private BigDecimal preco;
	
	@Column
	private LocalDate dataLancamento;
	
	@Column
	@ManyToOne()
	@JoinColumn(name = "livraria", referencedColumnName = "idLivraria")
	private Book livraria;
	
	@Column
	@ManyToMany()
	@JoinColumn(name = "autores", referencedColumnName = "idAutor")
	private List<Autor> autores;
	

	
	
	
	
	
	public Livro() {
		super();
	}

	//---------------------Get/Set------------------------------

	public UUID getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(UUID idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public Book getLivraria() {
		return livraria;
	}

	public void setLivraria(Book livraria) {
		this.livraria = livraria;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}
