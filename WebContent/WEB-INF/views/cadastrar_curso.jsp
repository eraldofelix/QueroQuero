<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/cad_curso.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/MascaraValidacao.js"></script>




<title>Cadastrar Curso</title>
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


<form id="Cadastro_Curso"  name="Cadastro_Curso" action="cadastrar_res" method="post">
	<fieldset id="field">
		<legend>Cadastro de Curso</legend>
		
		<div class="cad_curso">
		
			<div class="cad_curso_coluna_lb">
				
				
				<div class="cad_curso_linha">
				<Label for="nome" id="lb_cad_curso">Nome:</Label>
				</div>
				
				<div class="cad_curso_linha">
				<Label for="tema" id="lb_cad_curso">Tema:</Label>
				</div>
				
				<div class="cad_curso_linha">
				<label for="ch_curso" id="lb_cad_curso">Carga Horária:</label>
				</div>

				<div class="cad_curso_linha">
				<label for="publico_alvo" id="lb_cad_curso">Público-Alvo:</label>
				</div>				

				<div class="cad_curso_linha">
				<label for="pre_requisito" id="lb_cad_curso">Pré-Requisito:</label>
				</div>						
			
			</div>
			
			<div class="cad_curso_coluna_input">
			
				<div class="cad_curso_linha">
				<input type="text" id="nome" name="nome"/>
				</div>

				<div class="cad_curso_linha">
				<input type="text" id="tema" name="tema"/>
				</div>
				
				<div class="cad_curso_linha">
				<input type="text" maxlength="2" size="2" id="carga_horaria" name="carga_horaria"/>
				</div>

				<div class="cad_curso_linha">
				<input type="text" id="publico_alvo" name="publico_alvo"/>
				</div>

				<div class="cad_curso_linha">
				<input type="text" id="pre_requisito" name="pre_requisito"/>
				</div>

				<div class="cad_curso_linha">
				<input type="submit" title="cadastrar curso" class="botao" id="botao" value="Cadastrar"/>
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