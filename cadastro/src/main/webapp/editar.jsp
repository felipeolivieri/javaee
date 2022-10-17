<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar Produto</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Produto</h1>
	<form name="frmProduto" action="update">
		<table>
			<tr>
				<td><input type="text" name="idprod" id="caixa3" readonly value="<%out.print(request.getAttribute("idprod"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="produto" class="caixa1" value="<%out.print(request.getAttribute("produto"));%>"></td>
			</tr>
			<tr>
				<td>
					<textarea name="descricao" rows="5" cols="33" class="Desc1"><%out.print(request.getAttribute("descricao"));%></textarea>
  				</td>
			</tr>
			<tr>
				<td><input type="text" name="valor" class="caixa2" value="<%out.print(request.getAttribute("valor"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="quantidade" class=caixa2 value="<%out.print(request.getAttribute("quantidade"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>