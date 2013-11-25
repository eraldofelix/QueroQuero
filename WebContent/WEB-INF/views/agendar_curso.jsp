<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/cad_curso.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" />
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.8.2.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/dateinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/itens.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/modernizr.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.8.18.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery.ui.datepicker-pt-BR.js"></script>


<title>Agendar Curso</title>
</head>
<body>

<div class="tudo">

<div class="cabecalho">

</div>

<div id='cssmenu'>
<ul>
   <li><a href="home"><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Curso</span></a>
      <ul>
	   <li><a href="cadastrar"><span>Cadastrar</span></a></li>
	   <li><a href="pesquisar"><span>Pesquisar</span></a></li>
         <li class='last'><a href="agendar"><span>Agendar</span></a></li>
      </ul>
   </li>
</ul>
</div>

<form id="Agendar_Curso"  name="Agendar_Curso" action="agendar_res" method="post">
	<fieldset id="field">
		<legend>Agendar Aula</legend>
		
		<div class="cad_curso">
		
			<div class="cad_curso_coluna_lb">
				
				
				<div class="cad_curso_linha">
				<Label for="curso" id="lb_cad_curso">Curso:</Label>
				</div>
				
				<div class="cad_curso_linha">
				<Label for="data" id="lb_cad_curso">Data:</Label>
				</div>
				
				<div class="cad_curso_linha">
				<label for="hora_inicio" id="lb_cad_curso">Horário de início:</label>
				</div>
				
								<div class="cad_curso_linha">
				<label for="hora_final" id="lb_cad_curso">Horário de término:</label>
				</div>

				<div class="cad_curso_linha">
				<label for="professor" id="lb_cad_curso">Professor:</label>
				</div>				

				<div class="cad_curso_linha">
				<label for="sala" id="lb_cad_curso">Sala:</label>
				</div>					
			
			</div>
			
			<div class="cad_curso_coluna_input">
			
				<div class="cad_curso_linha">
					<select name="idcurso" id="idcurso">
					<c:forEach items="${cursos}" var="curso">
						<option value="${curso.idcurso}"> ${curso.nome}</option>
					</c:forEach>
					</select>
				</div>


				<div class="cad_curso_linha">
				<input type="text" id="data" name="data" class="data"/>
				</div>
				
				<div class="cad_curso_linha">
				<input type="text" maxlength="10" size="5" id="hora_inicio" name="hora_inicio"/>
				</div>
				
				<div class="cad_curso_linha">
				<input type="text" maxlength="10" size="5" id="hora_final" name="hora_final"/>
				</div>

				<div class="cad_curso_linha">
					<select name="idprofessor" id="idprofessor">
						<c:forEach items="${professores}" var="professor">
						<option value="${professor.idprofessor}"> ${professor.nome_prof}</option>
					</c:forEach>
					</select>
				</div>

				<div class="cad_curso_linha">
					<select name="sala" id="sala">
						<option value="hibrida01"> Híbrida 01</option>
						<option value="hibrida02"> Híbrida 02</option>
						<option value="hibrida03"> Híbrida 03</option>
						<option value="hibrida04"> Híbrida 04</option>
						<option value="hibrida05"> Híbrida 05</option>
						<option value="multimidia"> Multimídia</option>
					</select>
				</div>

				<div class="cad_curso_linha">
				<input type="submit" title="agendar curso" class="botao" id="botao" value="Agendar"/>
				</div>

			</div>
			
		</div>
		
	</fieldset>
</form>



<div class="rodape">

</div>

</div>



</body>
</html>