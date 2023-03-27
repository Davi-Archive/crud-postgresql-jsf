package git.jsf.adm.utils;

import java.util.List;

import org.junit.jupiter.api.Test;

import git.jsf.adm.dao.DaoGeneric;
import git.jsf.adm.model.TelefoneUser;
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
	pessoa.setNome("Davvi");
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

    @Test
    public void testeBuscar2() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = daoGeneric.pesquisarOutraForma(1L,
		UsuarioPessoa.class);

	System.out.println(pessoa);
    }

    @Test
    public void testeUpdate() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa = daoGeneric.pesquisarOutraForma(1L,
		UsuarioPessoa.class);

	pessoa.setIdade(99);
	pessoa.setNome("New Name");

	pessoa = daoGeneric.updateMerge(pessoa);

	System.out.println(pessoa);
    }

    @Test
    public void testeDelete() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	UsuarioPessoa pessoa1 = daoGeneric.pesquisarOutraForma(6L,
		UsuarioPessoa.class);
	UsuarioPessoa pessoa2 = daoGeneric.pesquisarOutraForma(7L,
		UsuarioPessoa.class);
	UsuarioPessoa pessoa3 = daoGeneric.pesquisarOutraForma(8L,
		UsuarioPessoa.class);

	daoGeneric.deletarPorId(pessoa1);
	daoGeneric.deletarPorId(pessoa2);
	daoGeneric.deletarPorId(pessoa3);

	System.out.println("Deletado com sucesso");
    }

    @Test
    public void testeConsultar() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	List<UsuarioPessoa> list = daoGeneric
		.listar(UsuarioPessoa.class);

	for (UsuarioPessoa usuarioPessoa : list) {
	    System.out.println(usuarioPessoa);
	    System.out.println("-----------------");
	}
    }

    @Test
    public void testQueryList() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

	List<UsuarioPessoa> list = daoGeneric.getEntityManager()
		.createQuery(
			" from UsuarioPessoa where nome = 'Davi'")
		.getResultList();

	for (UsuarioPessoa usuarioPessoa : list) {
	    System.out.println(usuarioPessoa);
	    System.out.println("-----------------");
	}
    }

    @Test
    public void testGravaTelefone() {
	DaoGeneric daoGeneric = new DaoGeneric();

	UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric
		.pesquisarOutraForma(10l, UsuarioPessoa.class);

	TelefoneUser telefoneUser = new TelefoneUser();

	telefoneUser.setTipo("Celular");
	telefoneUser.setNumero("405634032");
	telefoneUser.setUsuarioPessoa(pessoa);
	
	System.out.println(pessoa);
	
	System.out.println(telefoneUser);

	daoGeneric.salvar(telefoneUser);
    }
}
