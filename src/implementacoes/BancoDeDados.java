package implementacoes;

	import java.sql.DriverManager;

	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.sql.Connection;

	/**
	 * A classe: <b>BancoDeDados</b> e ultilizada para fazer a conexão com o banco de dados do MySQL. 
	 * <p>
	 * Os objetos que sao armazenados sao o Perfil, Qualidade e Carta, sendo que cada Carta possui 2 chaves estrangeiras
	 * para manter uma ligacao com um Perfil e uma Qualidade que sao caracteristicas de uma determinada Carta 
	 *</p>
	 * <p>
	 * O servidor e o localhost.
	 * </p>
	 * <p>
	 * Referindo-se a objetos(Perfil,Qualidade e Carta), a classe BancoDeDados, possui metodos para inserir,deletar
	 * ,Imprimir e buscar cada objeto(Perfil,Qualidade e Carta)
	 *  </p>
	 *  *
	 * @author Guilherme F. | Ualaci .A | Gustavo .B | Joao Marcos .P | Kaio .A   
	 * @version 1.0 (Junho-2019)
	 */
	public class BancoDeDados {
		//para fazer a conexao
		/**connection conecta com o MySql*/
		private java.sql.Connection connection = null;
		
		/**statement utilizada para executar instruções SQL.*/
		private Statement statement = null;
		
		/**resultsetQualidade utilizada para guardar dados do tipo Qualidade, vindos do banco de dados*/
		private ResultSet resultsetQualidade = null;
		
		/**resultsetPerfil utilizado para guardar dados do tipo Perfil, vindos do banco de dados*/
		private ResultSet resultsetPerfil = null;
		
		/**resultado utilizado para buscar dados do tipo(Qualidade e Perfil que formam uma Carta) vindos do banco de dados*/
		private ResultSet resultado = null;
		
		/**Metodo que realiza a conexao com o banco de dados MySql, servidor: localhost , porta 3306 , usuario root
		 * <p>
		 * connection recebe o driver de conexao e a statement pode entao ser ultilizada para realizar as instrucoes SQL.
		 * </p>*/
		public void conectar() {
			String servidor = "jdbc:mysql://localhost:3306/yugioh?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "a1s2d3f4g5h6j7k8l9";
			//local do driver
			String driver = "com.mysql.cj.jdbc.Driver";
			try {
				Class.forName(driver);
				//realiza a conexao
				this.connection=DriverManager.getConnection(servidor,usuario,senha);
				//cria a estrutura de consultas
				this.statement=this.connection.createStatement();
			}catch(Exception e) {}
		}
	/**Metodo Verifica se esta conectado
	 * @return boolean , true se esta conectado e false se nao esta conectado*/
	public boolean estaConectado() {
		if(this.connection!=null)
			return true;
		else
			return false;
	}
	
	/**Imprime na tela todos objetos do tipo Perfil que estao armazenados no banco de dados
	 * <p>Exemplo:</p>
	 * <p>
	 * 	ID: 1| Nome: Baby Dragon| Descricao: O dragao mais fofo e ardente queexiste | Imagem: Baby Dragon.jpg
	 * </p>
	 * <p>
	 * 	ID: 2| Nome: Mago Negro| Descricao: Bruxao roxo que rouba sua alma | Imagem: Dark Magician.jpg
	 * </p>
	 * 
	 */
	public void listarPerfil() {
		try {
			String query= "select * from perfil";
			//resultset recebe toda Query
			this.resultsetPerfil=this.statement.executeQuery(query);
			while(resultsetPerfil.next()) {
				System.out.println("ID: "+this.resultsetPerfil.getString("idPerfil")+"| Nome: "+this.resultsetPerfil.getString("nome")+"|"
						+ " Descricao: "+this.resultsetPerfil.getString("descricao")+ " | Imagem: "+this.resultsetPerfil.getString("imagem"));
			}
		}catch(Exception e) {}
	}
	
	/**Imprime na tela todos objetos do tipo Qualidade que estao armazenados no banco de dados
	 * <p>Exemplo:</p>
	 * <p>
	 * 	ID: 1| Tipo Dragao| Atributo: Fogo| Nivel: 10| Ataque: 5667.0| Defesa: 7353.0
	 *</p>
	 *<p>
	 *	ID: 2| Tipo Mago| Atributo: Escuridao| Nivel: 11| Ataque: 9999.0| Defesa: 7777.0
	 *</p>
	 */
	public void listarQualidade() {
		try {
			String query= "select * from Qualidade";
			//resultset recebe toda Query
			this.resultsetQualidade=this.statement.executeQuery(query);
			while(resultsetQualidade.next()) {
				System.out.println("ID: "+this.resultsetQualidade.getString("idQualidade")+"| Tipo "+this.resultsetQualidade.getString("tipo")+"| Atributo: "+this.resultsetQualidade.getString("atributo")+"| Nivel: "+this.resultsetQualidade.getString("nivel")+"| Ataque: "+this.resultsetQualidade.getString("ataque")+"| Defesa: "+this.resultsetQualidade.getString("defesa"));
			}
		}catch(Exception e) {}
	}
	
	/**Imprime na tela todos objetos do tipo Carta que estao armazenados no banco de dados
	 * <p>Exemplo: </p>
	 * <p>
	 * 	ID: 1| Nome: Baby Dragon| Descricao: O dragao mais fofo e ardente que existe | Imagem: Baby Dragon.jpg
	 * </p>
	 * <p>
	 * 	ID: 2| Nome: Mago Negro| Descricao: Bruxao roxo que rouba sua alma | Imagem: Dark Magician.jpg
 	 * </p>
 	 * <p>
	 * 	ID: 1| Tipo Dragao| Atributo: Fogo| Nivel: 10| Ataque: 5667.0| Defesa: 7353.0
	 * </p>
	 * <p>
	 * 	ID: 2| Tipo Mago| Atributo: Escuridao| Nivel: 11| Ataque: 9999.0| Defesa: 7777.0
	 * </p>
	 */
	public void listarCarta() {
		try {
			this.listarPerfil();
			System.out.println(" |");
			this.listarQualidade();

		}catch(Exception e) {}
	}
	
	/**Insere um objeto do tipo Perfil no Banco de Dados 
	 * 
	 * @param nome nome da Carta
  	 * @param descricao descricao da Carta
  	 * @param imagem imagem da Carta*/
	public void inserirPerfil(String nome , String descricao, String imagem) {
		try{
			String query = "INSERT INTO perfil (nome,descricao,imagem) VALUES ('"+nome+"','"+descricao+"','"+imagem+"');";
			this.statement.execute(query);
		}catch(Exception e){System.out.println(""+e.getMessage());}
		
	}
	
	/**Insere um objeto do tipo Qualidade no Banco de Dados 
	 * 
	 * @param tipo tipo da Carta
  	 * @param atributo atributo da Carta
  	 * @param nivel nivel da Carta
  	 * @param ataque ataque da Carta
  	 * @param defesa defesa da Carta*/
	public void inserirQualidade(String tipo , String atributo , int nivel , double ataque , double defesa) {
		try{
			String query = "INSERT INTO qualidade (tipo,atributo,nivel,ataque,defesa) VALUES ('"+tipo+"','"+atributo+"','"+nivel+"','"+ataque+"','"+defesa+"');";
			this.statement.execute(query);
		}catch(Exception e){}
		
	}
	
	/**Metodo sobrecarregado, recebe parametros individuais dos campos que compoem um Perfil e uma Qualidade. 
	 * Insere um objeto do tipo Carta no Banco de Dados, ultilizando os metodos (inserirPerfil , inserirQualidade) como metodos auxiliares
	 * 
	 * @param nome nome da Carta
  	 * @param descricao descricao da Carta
  	 * @param imagem imagem da Carta
	 * @param tipo tipo da Carta
  	 * @param atributo atributo da Carta
  	 * @param nivel nivel da Carta
  	 * @param ataque ataque da Carta
  	 * @param defesa defesa da Carta*/
	public void inserirCarta(String nome , String descricao ,String imagem, String tipo , String atributo , int nivel , double ataque , double defesa) {
		try{
			this.inserirQualidade(tipo, atributo, nivel, ataque, defesa);
			this.inserirPerfil(nome , descricao, imagem);
			String query = "INSERT INTO carta (Qualidade_idQualidade,Perfil_idPerfil) VALUES (LAST_INSERT_ID(),LAST_INSERT_ID())";
			this.statement.execute(query);
		}catch(Exception e){System.out.println(""+e.getMessage());}
		
	}
	
	/**Metodo sobrecarregado, recebe apenas um parametro do tipo Carta. 
	 * Insere um objeto do tipo Carta no Banco de Dados, ultilizando os metodos (inserirPerfil , inserirQualidade) como metodos auxiliares
	 *
	 *@param cart objeto do tipo Carta, que sera inserida no banco de dados
	 */
	public void inserirCarta(Carta cart) {
		try{
			this.inserirQualidade(cart.getQ().getTipo(),cart.getQ().getAtributo(), cart.getQ().getNivel(), cart.getQ().getAtaque(),cart.getQ().getDefesa());
			this.inserirPerfil(cart.getP().getNome() , cart.getP().getDescricao() , cart.getP().getImagem());
			String query = "INSERT INTO carta (Qualidade_idQualidade,Perfil_idPerfil) VALUES (LAST_INSERT_ID(),LAST_INSERT_ID())";
			this.statement.execute(query);
		}catch(Exception e){System.out.println(""+e.getMessage());}
		
	}
	
	/**Deleta objeto do tipo Perfil no Banco de Dados
	 * 
	 * @param id chave primaria de Perfil*/
	public void DeletarPerfil(String id) {
		try{
			String query="DELETE FROM perfil WHERE idPerfil ="+id+";";
			this.statement.executeUpdate(query);
		}catch(Exception e) {}
	}
	
	/**Deleta objeto do tipo Qualidade no Banco de Dados
	 * 
	 * @param id chave primaria de Qualidade*/
	public void DeletarQualidade(String id) {
		try{
			String query="DELETE FROM qualidade WHERE idQualidade ="+id+";";
			this.statement.executeUpdate(query);
		}catch(Exception e) {}
	}
	
	/**Deleta objeto do tipo Carta no Banco de Dados
	 * 
	 * @param id chave primaria de Carta*/
	public void DeletarCarta(String id) {
		try{
			String query="DELETE FROM Carta WHERE idCarta ="+id+";";
			this.statement.executeUpdate(query);
		}catch(Exception e) {}
	}
	
	/**  
	 * Metodo realiza uma busca no banco de dados, procurando todas as Cartas que estao de acordo com
  	 * os parametros passados como argumento, se algum parametro(tipo,atributo ou nivel) for igual a null 
  	 * a busca desconsidera o parametro que e null, se todos(tipo,atributo e nivel) forem iguais a null, a busca retorna todas as classes
  	 * do banco de dados
  	 * 
	 * @param tipo tipo das Cartas que seram buscadas
  	 * @param atributo atributo das Cartas que seram buscadas
  	 * @param nivel nivel das Cartas que seram buscadas
  	 * @param maxAtaque seram buscadas Cartas com ataque menor que maxAtaque 
  	 * @param minAtaque seram buscadas Cartas com ataque maior que minAtaque 
  	 * @param maxDefesa seram buscadas Cartas com defesa menor que maxDfesa 
  	 * @param minDefesa seram buscadas Cartas com defesa maior que minDfesa 
  	 * 
  	 * @return ResultSet ,dados das Cartas que foram encontradas
  	 * */
	public ResultSet busca (String tipo , String atributo, String nivel, String maxAtaque, String minAtaque, String maxDefesa, String minDefesa) {
		if(maxAtaque.equals("0"))System.out.println("esse 0 eh igual");
		String query = new String();
		
			//alternativa de query
			//tipo = tipo == null ? "" : "tipo='" + tipo + "'";
			//query = String.format("SELECT * FROM perfil,qualidade WHERE "+tipo+" and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			if(tipo!=null && atributo!=null && nivel!=null  )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and tipo = '"+tipo+"' and atributo= '"+atributo+"'and nivel= '"+nivel+"'and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
				
			else if (tipo!=null && atributo!=null && nivel==null )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and tipo = '"+tipo+"' and atributo= '"+atributo+"'and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			else if (tipo!=null && atributo==null && nivel==null )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and tipo = '"+tipo+"' and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			else if (tipo==null && atributo!=null && nivel!=null )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and atributo= '"+atributo+"'and nivel= '"+nivel+"'and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			else if (tipo!=null && atributo==null && nivel!=null )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and tipo = '"+tipo+"' and nivel= '"+nivel+"'and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			else if (tipo==null && atributo==null && nivel!=null )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and  nivel= '"+nivel+"'and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			else if (tipo==null && atributo!=null && nivel==null )
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and  atributo= '"+atributo+"'and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			
			else {
				query = String.format("SELECT * FROM perfil,qualidade WHERE idPerfil=idQualidade and ataque <= '"+maxAtaque+"'and ataque >='"+minAtaque+"'and defesa <='"+maxDefesa+"'and defesa >='"+minDefesa+"'");
			}
			
			try {
				
				this.resultado = this.statement.executeQuery(query);
				} catch(Exception e) {e.printStackTrace();}
			return this.resultado;
		}
	
	
	
	/**Metodo realiza a desconexao com o Banco de Dados MySql*/
	public void desconectar() {
		try{
			this.connection.close();
		}catch(Exception e) {System.out.println(""+e.getMessage());}
	}
	
	
}
