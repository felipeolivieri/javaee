package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de conexão *. */
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://mysql:3306/dbprodutos?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "dba";
	
	/** The password. */
	private String password = "MyDBAP@ssw0rd";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão
	private Connection conectar(){
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
				System.out.println(e);
				return null;
			}
	}
	//teste de conexão
	/**
	 * 	public void testeConexao() {
	 * 		try {
	 * 			Connection con = conectar();
	 * 			System.out.println(con);
	 * 			con.close();
	 * 		} catch (Exception e) {
	 * 			System.out.println(e);
	 * 		}
	 * 	}
	 *
	 * @param produto the produto
	 */
	/* CRUD CREATE */
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into cadastro (produto, descricao, valor, quantidade) values(?, ?, ?, ?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			//Preparar a query para execução no banaco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, produto.getProduto());
			pst.setString(2, produto.getDescricao());
			pst.setString(3, produto.getValor());
			pst.setString(4, produto.getQuantidade());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
				
	}
	
	/**
	 *  CRUD READ *.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarProdutos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		// TODO Auto-generated method stub
		String read = "select * from cadastro order by produto";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// laço abaixo será executadno enquanto houver produtos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco de dados
				String idprod = rs.getString(1);
				String produto = rs.getString(2);
				String descricao = rs.getString(3);
				String valor = rs.getString(4);
				String quantidade = rs.getString(5);
				//populando o ArrayList
				produtos.add(new JavaBeans(idprod,produto,descricao,valor,quantidade));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 *  CRUD UPDATE *.
	 *
	 * @param produto the produto
	 */
	// selecionar o Produto
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from cadastro where idprod = ? ";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getIdprod());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variáveis JavaBeans
				produto.setIdprod(rs.getString(1));
				produto.setProduto(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setValor(rs.getString(4));
				produto.setQuantidade(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
	
	/**
	 * Alterar produto.
	 *
	 * @param produto the produto
	 */
	// editar o produto
	public void alterarProduto(JavaBeans produto) {
		String update = "update cadastro set produto=?,descricao=?,valor=?,quantidade=? where idprod=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1,produto.getProduto());
			pst.setString(2,produto.getDescricao());
			pst.setString(3,produto.getValor());
			pst.setString(4,produto.getQuantidade());
			pst.setString(5,produto.getIdprod());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	/**
	 *  CRUD DELETE *.
	 *
	 * @param produto the produto
	 */
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from cadastro where idprod = ? ";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getIdprod());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

