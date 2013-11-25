<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Cursos</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/busca.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/busca_curso.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.9.2.custom.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/menu.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alterar.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.9.2.custom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/busca.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/alterar.js"></script>



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

<form id="Busca_Produto" action="pesquisar_res" method="post">

<fieldset>
<legend>Escolha um método de busca:</legend>

<div class="mudar">
<label class="opcoes"><input type="radio" id="acao" name="acao" value="nome" />Por Nome</label>
<span><label>Digite aqui o nome a ser pesquisado: <input type="text" id="nomeCurso" name="nomeCurso" /><input type="submit" title="Buscar" class="botao" id="botao" value="Buscar"/></label></span>
</div>

</fieldset>
</form>

<c:set var="resultado" value="${cursos}"/>
<c:choose>
  <c:when test="${resultado != null}">
<div class="res_busca">Resultado da Busca: </div>
<form id="Resultado_Busca" action="exclui_altera_curso" method="post">

<div class="linha_reg">

<div class="camp_reg_opcao"> 

</div>

<div class="camp" id="camp_codigo">
Carga Horária
</div>
<div class="camp">
Nome
</div>
<div class="camp"> 
Pré-Requisito
 </div>
<div class="camp"> 
Público-Alvo
</div>
<div class="camp">
Tema
</div>
</div>

<c:forEach items="${cursos}" var="curso">
	
<div class="linha_reg">

<div class="coluna_reg_opcao"> 
<input type="radio" id="opcao" name="opcao" value="${curso.idcurso}" />
</div>

<div class="coluna_reg">
${curso.carga_horaria} horas
</div>
<div class="coluna_reg">
${curso.nome}
</div>
<div class="coluna_reg"> 
${curso.pre_requisito}
 </div>
<div class="coluna_reg"> 
${curso.publico_alvo}
</div>
<div class="coluna_reg">
${curso.tema}
</div>
</div>
</c:forEach>

<div class="linha_reg">
<input type="submit" title="Excluir Registro" name="botao" id="botao" value="Excluir"/> 
<input type="submit" title="Alterar Registro" name="botao" id="botao" value="Alterar"/>
</div>

<br/><br/><br/><br/>
	

</form>
  </c:when> 

</c:choose>

<c:set var="alterar" value="${curso}"/>
<c:choose>
  <c:when test="${alterar != null}">
<div class="dialogo" title="Atualizar informações do Curso" >				
<form id="Cadastro_Curso" action="exclui_altera_curso"  method="post" >
<fieldset id="fiel" >
<legend>Cadastro de Curso</legend>
<div class="cad_curso" >

	<div class="cad_curso_coluna_lb" >

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
				<input type="text" id="nome" name="nome" value="${alterar.nome}"/>
				</div>

				<div class="cad_curso_linha">
				<input type="text" id="tema" name="tema" value="${alterar.tema}"/>
				</div>
				
				<div class="cad_curso_linha">
				<input type="text" maxlength="2" size="2" id="carga_horaria" name="carga_horaria" value="${alterar.carga_horaria}"/>
				</div>

				<div class="cad_curso_linha">
				<input type="text" id="publico_alvo" name="publico_alvo" value="${alterar.publico_alvo}"/>
				</div>

				<div class="cad_curso_linha">
				<input type="text" id="pre_requisito" name="pre_requisito" value="${alterar.pre_requisito}"/>
				</div>
		
		<div class="cad_curso_linha" >
					<input type="submit" title="Salvar" class="botao" name="botao" id="botao" value="Salvar" style="float:right; margin-right: 25px"/>
		</div>
		
	</div>
	
</div>
</fieldset>
</form>
</div>
  </c:when> 
</c:choose>



<div class="rodape">

</div>
</div>





</body>
</html>