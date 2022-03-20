package cadastro.modelo;

public class Aluno {

	private Integer id;
	private String nome;
	private String email;
	
	
	public Aluno(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		
	}
	
	public Aluno(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public Aluno() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
	
}
