package model.entity;
import java.awt.print.Book;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class Autor {

	@Id
	private UUID idAutor;
	
	@Column
	private String nome;
	
	@Column 
	private String sexo;
	
	@Column
	@ManyToMany
	@JoinColumn(name = "livros", referencedColumnName = "idLivro")
	private List<Book> livros;
	
	
	public Autor() {
		super();
	}

	//---------------------Get/Set------------------------------

	public UUID getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(UUID idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Book> getLivros() {
		return livros;
	}

	public void setLivros(List<Book> livros) {
		this.livros = livros;
	}

	
	
	
}
