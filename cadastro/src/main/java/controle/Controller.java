package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The produto. */
	JavaBeans produto = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			adicionarProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		/**
		 * teste de conexão dao.testeConexao();
		 **/
	}

	/**
	 * Produtos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// listar produtos
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		/**
		 * // teste de recebimento da lista -> isso imprime tudo na console for (int i =
		 * 0; i < lista.size(); i++) { System.out.println(lista.get(i).getIdprod());
		 * System.out.println(lista.get(i).getProduto());
		 * System.out.println(lista.get(i).getDescricao());
		 * System.out.println(lista.get(i).getValor());
		 * System.out.println(lista.get(i).getQuantidade()); }
		 */
		// Encaminhar a lista ao documento cadastro.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo produto
	protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * teste de recebimento dos dados do formulário
		 * System.out.println(request.getParameter("produto"));
		 * System.out.println(request.getParameter("descricao"));
		 * System.out.println(request.getParameter("valor"));
		 * System.out.println(request.getParameter("quantidade"));
		 */
		// setar as variáveis JavaBeans
		produto.setProduto(request.getParameter("produto"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setValor(request.getParameter("valor"));
		produto.setQuantidade(request.getParameter("quantidade"));
		// invocar o método inserirProduto passando o objeto produto
		dao.inserirProduto(produto);
		// redirecionar para o documento cadastro.jsp
		response.sendRedirect("main");
	}
	
	/**
	 * Listar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar Contato
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do produto que será editado
		String idprod = request.getParameter("idprod");
		/** testando o request
		System.out.println(idprod); */
		// setar a variável JavaBeans
		// note que podemos reduzir o código substituindo a variavel idprod abaixo pelo request.getParameter("idprod") feito para definir a variavel idprod.
		produto.setIdprod(idprod);
		// executar o método selecionarContato da classe DAO
		dao.selecionarProduto(produto);
		/** teste de recebimento
		System.out.println(produto.getIdprod());
		System.out.println(produto.getProduto());
		System.out.println(produto.getDescricao());
		System.out.println(produto.getValor());
		System.out.println(produto.getQuantidade()); */
		// setar os atributos do formulário com o conteúdo Javabeans
		request.setAttribute("idprod", produto.getIdprod());
		request.setAttribute("produto", produto.getProduto());
		request.setAttribute("descricao", produto.getDescricao());
		request.setAttribute("valor", produto.getValor());
		request.setAttribute("quantidade", produto.getQuantidade());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Editar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento
/**		System.out.println(request.getParameter("idprod"));
		System.out.println(request.getParameter("produto"));
		System.out.println(request.getParameter("descricao"));
		System.out.println(request.getParameter("valor"));
		System.out.println(request.getParameter("quantidade"));
*/	
		// setar as variáveis JavaBeans
		produto.setIdprod(request.getParameter("idprod"));
		produto.setProduto(request.getParameter("produto"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setValor(request.getParameter("valor"));
		produto.setQuantidade(request.getParameter("quantidade"));
		// executar o método alterarProduto
		dao.alterarProduto(produto);
		// redirecionar para o documento cadastro.jsp (atualizando as alteracoes)
		response.sendRedirect("main");
	}	

	/**
	 * Remover produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// remover um contato
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do ID do produto a ser excluido (confirmador.js)
		String idprod = request.getParameter("idprod");
		// testando recebimento da variavel idprod
		// System.out.println(idprod);
		// setar variavel idprod JavaBeans
		// Note que podemos reduzir o código, substituindo a variavel idprod abaixo pelo request.getParameter("idprod") da linha 154.
		produto.setIdprod(idprod);
		// executar o método deletarProduto (DAO) passando o objeto produto
		dao.deletarProduto(produto);
		// redirecionar para o documento cadastro.jsp (atualizando as alteracoes)
		response.sendRedirect("main");
		
	}
}
	
