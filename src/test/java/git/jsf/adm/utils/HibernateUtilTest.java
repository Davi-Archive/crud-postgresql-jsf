package git.jsf.adm.utils;

import org.junit.jupiter.api.Test;

import git.jsf.adm.dao.DaoGeneric;
import git.jsf.adm.model.UsuarioPessoa;

public class HibernateUtilTest {

    @Test
    public void testHibernateUtil() {
	HibernateUtil.getEntityManager();
    }

    @Test
    public void testEntidadeSalvar() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = new UsuarioPessoa();

	pessoa.setIdade(45);
	pessoa.setLogin("teste");
	pessoa.setNome("Davi");
	pessoa.setSenha("123");
	pessoa.setSobrenome("Olive");
	pessoa.setEmail("email@email.com");

	daoGeneric.salvar(pessoa);

    }
    
    
    @Test
    public void testeBuscar() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = new UsuarioPessoa();
	pessoa.setId(1L);
	
	pessoa = daoGeneric.pesquisar(pessoa);
	
	System.out.println(pessoa);
    }

}
