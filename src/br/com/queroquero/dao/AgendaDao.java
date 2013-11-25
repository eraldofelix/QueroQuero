package br.com.queroquero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.queroquero.model.Agenda;

public class AgendaDao {

private final Session sessao;
	
public AgendaDao() {
	@SuppressWarnings("deprecation")
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	sessao = sf.openSession();
	
	}

public void salvar(Agenda agenda) {
	Transaction transacao = this.sessao.beginTransaction();
	sessao.save(agenda);
	transacao.commit();
}

public List<Agenda> listarTudo() {
	return this.sessao.createCriteria(Agenda.class).list();
}



}
