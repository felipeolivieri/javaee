/**
 * Confirmação de exclusao de um produto
 * @autor Felipe Olivieri
 * @param idprod
 */
 
 function confirmar(idprod){
	let resposta = confirm("Confirma a exclusão deste produto?")
	if (resposta === true){
		//alert(idprod)
		window.location.href = "delete?idprod=" + idprod
	}
}
