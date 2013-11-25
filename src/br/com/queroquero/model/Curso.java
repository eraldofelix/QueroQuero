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
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcurso", nullable=false, length=11)
	private Long idcurso;
	
	@Column(nullable=false ,length=255)
	private String nome;
	
	@Column(nullable=false ,length=50)
	private String tema;
	
	@Column(nullable=false)
	private int carga_horaria;
	
	@Column(nullable=false ,length=50)
	private String publico_alvo;
	
	@Column(nullable=false ,length=100)
	private String pre_requisito;

	@OneToMany(mappedBy = "curso", targetEntity = Agenda.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Agenda> agenda;
	
	
	
	public Collection<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(Collection<Agenda> agenda) {
		this.agenda = agenda;
	}

	public Long getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Long idcurso) {
		this.idcurso = idcurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getPublico_alvo() {
		return publico_alvo;
	}

	public void setPublico_alvo(String publico_alvo) {
		this.publico_alvo = publico_alvo;
	}

	public String getPre_requisito() {
		return pre_requisito;
	}

	public void setPre_requisito(String pre_requisito) {
		this.pre_requisito = pre_requisito;
	}
	

}
