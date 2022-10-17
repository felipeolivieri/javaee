/**
 * Validação do formulário de cadastro de novos produtos
 * @autor Felipe Olivieri
 */
 function validar (){
	let produto = frmProduto.produto.value
	let valor = frmProduto.valor.value
	let quantidade = frmProduto.quantidade.value
	if (produto === ""){
		alert('Preencha o campo Produto')
		frmContato.produto.focus()
		return false
	} else if (valor === ""){
		alert('Preencha o campo Valor')
		frmContato.valor.focus()
		return false
	} else if (quantidade === ""){
		alert('Preencha o campo Quantidade')
		frmContato.quantidade.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}
}



/** testando -> eu escrevi a funcao validar somente com este alerta e funcionou! 
*agora é fazer o teste para os campos não serem preenchidos vazio.
*
* alert('Teste')
*/
	