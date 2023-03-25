package git.jsf.adm;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "pessoaBean")
@RequestScoped
public class PessoaBean {

    private String nome;

    private List<String> nomes = new ArrayList<String>();

    public void addNome() {
	nomes.add(nome);
    }

    public List<String> getNomes() {
	return nomes;
    }

    public void setNomes(List<String> nomes) {
	this.nomes = nomes;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

}
