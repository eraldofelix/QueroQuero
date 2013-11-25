package br.com.queroquero.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.queroquero.dao.AgendaDao;
import br.com.queroquero.dao.CursoDao;
import br.com.queroquero.dao.ProfessorDao;
import br.com.queroquero.model.Agenda;
import br.com.queroquero.model.Curso;
import br.com.queroquero.model.Professor;

/*
 PROJETO DESENVOLVIDO PARA A AV1 DE PSW - IST-RIO
 ALUNO: BRUNO CROCAMO
 MATR�CULA: 1210470400009
 OBJETIVO: USAR SPRING MVC
 O  QUE FOI FEITO: FOI UTILIZADO SPRING MVC E HIBERNATE
 OPERA��ES IMPLEMENTADAS: CADASTRAR, PESQUISAR, ALTERAR E EXCLUIR
 
 � UM PROT�TIPO. O OBJETIVO ERA SOMENTE FAZER FUNCIONAR O SPRING MVC.
 N�O TEM NENHUM TIPO DE VALIDA��O DOS DADOS INSERIDOS PELO USU�RIO
 PARA AGENDAR � NECESS�RIO TER A LISTA DE PROFESSORES J� CADASTRADA NO BANCO DE DADOS
 SE N�O HOUVER PROFESSOR N�O HAVER� OP��O PARA O USU�RIO NO FORMUL�RIO DE AGENDAMENTO
 CARGA HOR�RIA DEVE SER PREENCHIDA APENAS COM NUMERO
 ESTE PROGRAMA FAZ O QUE O PROFESSOR PEDIU: LISTA CURSOS NUMA P�GINA
 PARA LISTAR CURSOS BASTA IR EM PESQUISAR E N�O DIGITAR NADA NA BUSCA, APENAS MANDAR BUSCAR
 IR� APARECER TODOS OS CURSOS CADASTRADOS. 
 
 AL�M DO QUE O PROFESSOR PEDIU H� A OP��O DE ALTERAR E DE EXCLUIR REGISTRO
 USEI HIBERNATE PARA PERSISTIR OS OBJETOS.
 A OP��O DE BUSCA FUNCIONA DA SEGUINTE FORMA:
 SE N�O DIGITAR NADA BUSCA TODOS OS CURSOS;
 SE DIGITAR ALGO, BUSCA TODOS OS CURSOS QUE TENHA AQUELA STRING NO NOME DO CURSO
 OU SEJA, SE DIGITAR "E" APARECER� TODOS OS CURSOS QUE TENHAM A LETRA "E" NO NOME
 */

@Controller
public class cursoController {
	
	@RequestMapping("/cadastrar")
	  public String cadastrar() {
		      
	      return "cadastrar_curso";
	  }
	
	@RequestMapping("/cadastrar_res")
	  public String cadastrarCurso(Curso curso) {
		        
	      CursoDao cursodao = new CursoDao();
	      cursodao.salvar(curso);
	      
	      return "cadastrar_curso";
	  }
	
	@RequestMapping("/agendar")
	  public String agendarCursos(Model model) {
	      System.out.println("agendar cursos disponiveis");
	      CursoDao cursos_dao = new CursoDao();
	      List<Curso> cursos = cursos_dao.listarTudo();
	     
	      ProfessorDao professor_dao = new ProfessorDao();
	      List<Professor> professores = professor_dao.listarTudo();
	      model.addAttribute("cursos", cursos);
	      model.addAttribute("professores", professores);
	      return "agendar_curso"; 	
	  }
	
	@RequestMapping("/agendar_res")
	  public String agendaCurso(Agenda agenda, String idcurso, Professor professor, Model model) {
		  	      
	      CursoDao cursodao = new CursoDao();
	      ProfessorDao professordao = new ProfessorDao();
	      
	      agenda.setCurso(cursodao.carregar(Long.parseLong(idcurso)));
	      agenda.setProfessor(professordao.carregar(professor.getIdprofessor()));
	           
	      AgendaDao agendadao = new AgendaDao();
	      agendadao.salvar(agenda);
	      
	      List<Curso> cursos = cursodao.listarTudo();
	      List<Professor> professores = professordao.listarTudo();
	      
	      model.addAttribute("cursos", cursos);
	      model.addAttribute("professores", professores);
	      
	      return "agendar_curso";
	  }
	
	@RequestMapping("/pesquisar")
	  public String pesquisar() {
	      return "pesquisar_curso";
	  }
	
	@RequestMapping("/pesquisar_res")
	  public String pesquisarCurso(String acao, String nomeCurso, Model model, HttpSession sessao) {
	      
		CursoDao cursodao = new CursoDao();
		List<Curso> cursos = new ArrayList<Curso>();
	      switch(acao){
	      case "nome":
	    	  cursos = cursodao.BuscaNome(nomeCurso);
	    	  break;
	      }
	      sessao.setAttribute("parametro", nomeCurso);
	      model.addAttribute("cursos", cursos);
	      return "pesquisar_curso";
	  }
	
	@RequestMapping("/exclui_altera_curso")
	  public String exclui_alteraCurso(String opcao, String botao, Model model, HttpSession sessao, Curso curso) {

		CursoDao cursodao = new CursoDao();
		List<Curso> cursos = new ArrayList<Curso>();

		switch(botao){
	      case "Alterar":
	    	  if (!opcao.isEmpty()){
	    		Curso curso_al = new Curso();
	  			curso_al = cursodao.carregar(Long.parseLong(opcao));
	  			model.addAttribute("curso", curso_al);
	  			}
	    	  
	    	  break;
	      case "Excluir":
	    	  if (!opcao.isEmpty()){
		    		Curso curso_ex = new Curso();
		  			curso_ex = cursodao.carregar(Long.parseLong(opcao));
		  			cursodao.remover(curso_ex);
		  			model.addAttribute("curso", null);
	    	  }
	    	  break;
	    	  
	      case "Salvar":
	    	  curso.setIdcurso(Long.parseLong((String)sessao.getAttribute("opcao")));
		      cursodao.alterar(curso);
		      model.addAttribute("curso", null);
	    	  break;
	      }
		
		sessao.setAttribute("opcao", opcao);
	    cursos = cursodao.BuscaNome((String)sessao.getAttribute("parametro"));
	    model.addAttribute("cursos", cursos);
	      
	    return "pesquisar_curso";
	  }
}
