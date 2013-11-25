package br.com.queroquero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.queroquero.model.Professor;

public class ProfessorDao {

	private final Session sessao;

	public ProfessorDao() {
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		sessao = sf.openSession();

	}

	public void salvar(Professor professor) {
		Transaction transacao = this.sessao.beginTransaction();
		sessao.save(professor);
		transacao.commit();
	}

	public List<Professor> listarTudo() {
		return this.sessao.createCriteria(Professor.class).list();
	}

	public Professor carregar(Long idprofessor) {
		return (Professor) sessao.load(Professor.class, idprofessor);
	}
	
	
}
