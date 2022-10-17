<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@ SuppressWarnings ("unchecked")	
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
/**	for (int i = 0; i < lista.size();i++){
		out.println(lista.get(i).getIdprod());
		out.println(lista.get(i).getProduto());
		out.println(lista.get(i).getDescricao());
		out.println(lista.get(i).getValor());
		out.println(lista.get(i).getQuantidade());
	}*/

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Cadastro de produtos</h1>
	<a href="novo.html" class="botao1">Novo Produto</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Produto</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {  %>
				<tr>
					<td><%=lista.get(i).getIdprod()%></td>
					<td><%=lista.get(i).getProduto()%></td>
					<td><%=lista.get(i).getDescricao()%></td>
					<td>R$ <%=lista.get(i).getValor()%></td>
					<td align="center"><%=lista.get(i).getQuantidade()%></td>
					<td><a href="select?idprod=<%=lista.get(i).getIdprod() %>" class="botao1">Editar</a>
						<a href="javascript: confirmar(<%=lista.get(i).getIdprod() %>)" class="botao2">Excluir</a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>