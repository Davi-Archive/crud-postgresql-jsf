package git.jsf.adm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UsuarioPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String login;
    private String senha;
    private Integer idade;

    @OneToMany(mappedBy = "usuarioPessoa")
    private List<TelefoneUser> telefoneUsers;

    public UsuarioPessoa() {
	super();
    }

    public UsuarioPessoa(Long id, String nome, String sobrenome,
	    String email, String login, String senha) {
	super();
	this.id = id;
	this.nome = nome;
	this.sobrenome = sobrenome;
	this.email = email;
	this.login = login;
	this.senha = senha;
    }

    public List<TelefoneUser> getTelefoneUsers() {
	return telefoneUsers;
    }

    public void setTelefoneUsers(List<TelefoneUser> telefoneUsers) {
	this.telefoneUsers = telefoneUsers;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getSobrenome() {
	return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
	this.sobrenome = sobrenome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public Integer getIdade() {
	return idade;
    }

    public void setIdade(Integer idade) {
	this.idade = idade;
    }

    @Override
    public String toString() {
	return "UsuarioPessoa [id=" + id + ", nome=" + nome
		+ ", sobrenome=" + sobrenome + ", email=" + email
		+ ", login=" + login + ", senha=" + senha + ", idade="
		+ idade + "]";
    }

}
