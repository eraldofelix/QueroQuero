package br.com.queroquero.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idprofessor", nullable=false, length=11)
	private Long idprofessor;
	
	@Column(nullable=false ,length=100)
	private String nome_prof;
	
	@Column(nullable=false ,length=255)
	private String qualificacao_prof;

	@OneToMany(mappedBy = "professor", targetEntity = Agenda.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Agenda> agenda;

	public Long getIdprofessor() {
		return idprofessor;
	}

	public void setIdprofessor(Long idprofessor) {
		this.idprofessor = idprofessor;
	}

	public String getNome_prof() {
		return nome_prof;
	}

	public void setNome_prof(String nome_prof) {
		this.nome_prof = nome_prof;
	}

	public String getQualificacao_prof() {
		return qualificacao_prof;
	}

	public void setQualificacao_prof(String qualificacao_prof) {
		this.qualificacao_prof = qualificacao_prof;
	}

	public Collection<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(Collection<Agenda> agenda) {
		this.agenda = agenda;
	}
	
		
}
