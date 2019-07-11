package implementacoes;
/**
 * A classe: <b>Qualidade</b> possui respectivamente 5 campos: tipo, atributo, nivel, ataque e defesa. A classe Qualidade e ultilizada na estrutura da classe Carta, para definir caracteristicas gerais
 * de um objeto Carta, essas caracteristicas sao: tipo(Mago,Besta,Guerreiro, ...), atributo(Fogo,Escuridao,Agua, ...), nivel(3,7,12, ...), ataque(124,3423,341 ...) e defesa(235, 7543, 2344, ...)
 * @author Guilherme F. | Ualaci .A | Gustavo .B | Joao Marcos .P | Kaio .A   
 * @version 1.0 (Junho-2019)
 */
public class Qualidade {
	
	//campos
	/**tipo da carta exemplo(Mago,Besta,Guerreiro, ...)*/
	private String tipo;
	
	/**atributo da carta exemplo(Fogo,Escuridao,Agua, ...)*/
	private String atributo;
	
	/**nivel da carta exemplo(3,7,12, ...)*/
	private int nivel;
	
	/**ataque da carta exemplo(124,3423,341 ...)*/
	private double ataque;
	
	/**defesa da carta exemplo(235, 7543, 2344, ...)*/
	private double defesa;
	
	//construtores sobrecarregados

	/**
  	 * construtor para inicializar valores nos campos e inserir uma Qualidade em um banco de dados
  	 *
  	 * @param _tipo tipo da Carta
  	 * @param _atributo atributo da Carta
  	 * @param _nivel nivel da Carta
  	 * @param _ataque ataque da Carta
  	 * @param _defesa defesa da Carta
  	 * @param bd Banco de dados que armazena o Qualidade da Carta
  	 */
	public Qualidade(BancoDeDados bd,String _tipo, String _atributo , int _nivel , double _ataque , double _defesa) {
		this.setAtaque(_ataque);
		this.setAtributo(_atributo);
		this.setDefesa(_defesa);
		this.setNivel(_nivel);
		this.setTipo(_tipo);
		bd.inserirQualidade(_tipo, _atributo, _nivel, _ataque, _defesa);
	}

	/**
  	 * construtor para inicializar valores nos campos
  	 *
  	 * @param _tipo tipo da Carta
  	 * @param _atributo atributo da Carta
  	 * @param _nivel nivel da Carta
  	 * @param _ataque ataque da Carta
  	 * @param _defesa defesa da Carta
  	 */
	public Qualidade(String _tipo, String _atributo , int _nivel , double _ataque , double _defesa) {
		this.setAtaque(_ataque);
		this.setAtributo(_atributo);
		this.setDefesa(_defesa);
		this.setNivel(_nivel);
		this.setTipo(_tipo);
	}
	
	/**
  	 * pega o tipo
  	 *
  	 * @return tipo
  	 */
	public String getTipo() {
		return this.tipo;
	}
	
	/**
  	 * pega o atributo
  	 *
  	 * @return atributo
  	 */
	public String getAtributo() {
		return this.atributo;
	}
	
	/**
  	 * pega o nivel
  	 *
  	 * @return nivel
  	 */
	public int getNivel() {
		return this.nivel;
	}
	
	/**
  	 * pega o ataque
  	 *
  	 * @return ataque
  	 */
	public double getAtaque() {
		return this.ataque;
	}
	
	/**
  	 * pega a defesa
  	 *
  	 * @return defesa
  	 */
	public double getDefesa() {
		return this.defesa;
	}

	/**
  	 * modifica o campo tipo 
  	 * 
  	 * @param _tipo novo tipo da Carta
  	 */
	public void setTipo(String _tipo) {
		this.tipo = _tipo;
	}

	/**
  	 * modifica o campo atributo 
  	 * 
  	 * @param _atributo novo atributo da Carta
  	 */
	public void setAtributo(String _atributo) {
		this.atributo = _atributo;
	}

	/**
  	 * modifica o campo nivel 
  	 * 
  	 * @param _nivel novo nivel da Carta
  	 */
	public void setNivel(int _nivel) {
		this.nivel = _nivel;
	}

	/**
  	 * modifica o campo ataque 
  	 * 
  	 * @param _ataque novo ataque da Carta
  	 */
	public void setAtaque(double _ataque) {
		this.ataque = _ataque;
	}

	/**
  	 * modifica o campo defesa 
  	 * 
  	 * @param _defesa novo defesa da Carta
  	 */
	public void setDefesa(double _defesa) {
		this.defesa = _defesa;
	}

	/**Metodo compara dois objetos Qualidade e verifica se sao iguais
	 * 
	 * @param q Qualidade a ser comparada
	 * 
	 * @return boolean , true se todos os campos forem iguais e false se todos os campos forem diferentes
	 * */
	public boolean equals(Qualidade q) {
		if (this.getTipo()==q.getTipo() && this.getAtributo()==q.getAtributo() 
				&& this.getNivel()==q.getNivel() && this.getAtaque()==q.getAtaque() && this.getDefesa()==q.getDefesa())
			return true;
		else 
			return false;
	}

	/**Metodo compara dois objetos Qualidade e verifica qual e maior, ultilizando o campo nivel como criterio de verificacao
	 * 
	 * @param q Qualidade a ser comparado
	 *
	 * @return inteiro, 1 se maior, -1 se menor ou 0 se igual
	 * */
	public int compareTo(Qualidade q) {
		
		if(this.getNivel() > q.getNivel())
			return 1;
		else if(this.getNivel() < q.getNivel())
			return -1;
		else
			return 0;
	}
	
	/**
  	 * Sobreposição do método toString para retornar todo o conteudo de Qualidade
  	 * <p>Exemplo: </p>
  	 	*<p> Tipo: fera</p>
		*<p>Atributo: terra</p>
		*<p>Nivel: 5</p>
		*<p>Ataque: 34443.0</p>
		*<p>Defesa: 2342.0</p>
  	 * @return retorna um String com todos os dados
  	 */
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("Tipo: ");
		dados.append(this.getTipo());
		dados.append("\nAtributo: ");
		dados.append(this.getAtributo());
		dados.append("\nNivel: ");
		dados.append(this.getNivel());
		dados.append("\nAtaque: ");
		dados.append(this.getAtaque());
		dados.append("\nDefesa: ");
		dados.append(this.getDefesa());
		return dados.toString();
	}
}