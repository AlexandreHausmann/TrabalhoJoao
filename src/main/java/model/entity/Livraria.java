package model.entity;
import java.awt.print.Book;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity(name = "Livraria")
@Table(name = "livraria")
public class Livraria {
	
	@Id
	private UUID idLivraria;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column 
	private String cnpj;
	
	@Column
	@OneToMany
	@JoinColumn(name = "idLivraria",referencedColumnName = "livraria")
	private List<Book> book;


	
	public Livraria() {
		super();
	}

	//---------------------Get/Set------------------------------
	
	public UUID getIdlivraria() {
		return idLivraria;
	}

	public void setIdlivraria(UUID idlivraria) {
		this.idLivraria = idlivraria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public UUID getIdLivraria() {
		return idLivraria;
	}

	public void setIdLivraria(UUID idLivraria) {
		this.idLivraria = idLivraria;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
	


}
