package git.jsf.adm;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

    private String nome;

    private HtmlCommandButton commandButton;

    public HtmlCommandButton getCommandButton() {
	return commandButton;
    }

    public void setCommandButton(HtmlCommandButton commandButton) {
	this.commandButton = commandButton;
    }

    private List<String> nomes = new ArrayList<String>();

    public void addNome() {
	nomes.add(nome);
	if (nomes.size() > 3) {
	    commandButton.setDisabled(true);
	}
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