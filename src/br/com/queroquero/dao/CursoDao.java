package br.com.queroquero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import br.com.queroquero.model.Curso;

public class CursoDao {
	
private final Session sessao;

public CursoDao() {
	
	@SuppressWarnings("deprecation")
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	sessao = sf.openSession();

}

public void salvar(Curso curso) {
	Transaction transacao = this.sessao.beginTransaction();
	sessao.save(curso);
	transacao.commit();
}

public void alterar(Curso curso) {
	Transaction transacao = this.sessao.beginTransaction();
	sessao.update(curso);
	transacao.commit();
}

public void remover(Curso curso) {
	Transaction transacao = this.sessao.beginTransaction();
	sessao.delete(curso);
	transacao.commit();
}

public List<Curso> listarTudo() {
	return this.sessao.createCriteria(Curso.class).list();
}

public List<Curso> BuscaNome(String nome) {  
	   if (nome == null || nome.trim().equals(""))  
	       return (List<Curso>) this.sessao.createCriteria(Curso.class).list();  
	   return (List<Curso>) this.sessao.createCriteria(Curso.class).add(Restrictions.ilike("nome", "%"+nome+"%")).list();  
	}

public Curso carregar(Long idcurso) {
	return (Curso) sessao.load(Curso.class, idcurso);
}

}
