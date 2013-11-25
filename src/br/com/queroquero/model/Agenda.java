package br.com.queroquero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idagenda", nullable=false, length=11)
	private Long idagenda;
	
	@Column(nullable=false ,length=10)
	private String data; 
	
	@Column(nullable=false ,length=10)
	private String hora_inicio;
	
	@Column(nullable=false ,length=10)
	private String hora_final;
	
	@Column(nullable=false ,length=50)
	private String sala;
	
	@ManyToOne(optional=true, targetEntity= Curso.class, fetch= FetchType.LAZY)
	@JoinColumn(name="idcurso",nullable=true, insertable=true, updatable=true)
	private Curso curso;
	
	@ManyToOne(optional=true, targetEntity= Professor.class, fetch= FetchType.LAZY)
	@JoinColumn(name="idprofessor",nullable=true, insertable=true, updatable=true)
	private Professor professor;

	public Long getIdagenda() {
		return idagenda;
	}

	public void setIdagenda(Long idagenda) {
		this.idagenda = idagenda;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_final() {
		return hora_final;
	}

	public void setHora_final(String hora_final) {
		this.hora_final = hora_final;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
