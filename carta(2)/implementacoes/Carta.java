package implementacoes;
/**
 * A classe: <b>Carta</b> possui respectivamente um campo Perfil p e um campo Qualidade q.
 * Portanto a classe Carta possui caracteristicas unicas em seu campo p(nome,descricao e imagem)
 * e possui caracteristicas gerais em seu campo q(tipo,atributo,nivel,ataque e defesa)
 * @author Guilherme F. | Ualaci .A | Gustavo .B | Joao Marcos .P | Kaio .A   
 * @version 1.0 (Junho-2019)
 */

public class Carta {
	//campos
	/** Perfil da carta, caracteristicas unicas (nome,descricao e imagem)*/
	private Perfil p;
	/** Qualidade da carta, caracteristicas gerais (tipo,atributo,nivel,ataque e defesa)*/
	private Qualidade q;
	
	/**
  	 * construtor para inicializar valores nos campos
  	 *
  	 * @param _q Qualidade da Carta
  	 * @param _p Perfil da Carta
  	 */
	public Carta(Perfil _p , Qualidade _q) {
		this.setP(_p);
		this.setQ(_q);
	}
	
	/**
  	 * construtor para inicializar valores nos campos e inserir a Carta em um banco de dados
  	 *
  	 * @param _q Qualidade da Carta
  	 * @param _p Perfil da Carta
  	 * @param bd Banco de dados que armazena a Carta
  	 */
	public Carta(BancoDeDados bd ,Perfil _p , Qualidade _q) {
		this.setP(_p);
		this.setQ(_q);
		bd.inserirCarta(_p.getNome(),_p.getDescricao(),_p.getImagem(), _q.getTipo(),_q.getAtributo(),_q.getNivel(),_q.getAtaque(),_q.getDefesa());
	}
	
	/**
  	 * pega o Perfil
  	 *
  	 * @return p
  	 */
	public Perfil getP() {
		return this.p;
	}
	
	/**
  	 * pega a Qualidade
  	 *
  	 * @return q
  	 */
	public Qualidade getQ() {
		return this.q;
	}

	/**
  	 * modifica o campo p 
  	 * 
  	 * @param _p novo Perfil da Carta
  	 */
	public void setP(Perfil _p) {
		this.p = _p;
	}

	/**
  	 * modifica o campo q 
  	 * 
  	 * @param _q nova Qualidade da Carta
  	 */
	public void setQ(Qualidade _q) {
		this.q = _q;
	}
	
	/**Metodo compara dois objetos Carta e verifica se sao iguais,
	 *  ultilizando o equals das classes Perfil e Qualidade
	 * 
	 * @param c Carta a ser comparada
	 * 
	 * @return boolean , true se todos os campos forem iguais e false se todos os campos forem diferentes
	 * */
	public boolean equals(Carta c) {
		if (this.getP().equals(c.getP()) && this.getQ().equals(c.getQ()))
			return true;
		else 
			return false;
	}

	/**Metodo compara dois objetos Carta e verifica qual e maior,
	 *  ultilizando o compareTo da classe Qualidade
	 * 	 que ultiliza o campo nivel como criterio de verificacao
	 * 
	 * @param c Carta a ser comparado
	 *
	 * @return inteiro, 1 se maior, -1 se menor ou 0 se igual
	 * */
	public int compareTo(Carta c) {
		return this.getQ().compareTo(c.getQ());
	}
	
	/**
  	 * Sobreposição do método toString para retornar todo o conteudo de Carta
  	 * ultilizando o toString das classes Perfil e Qualidade
  	 * 
  	 * <p>Exemplo: </p>
  	 * 	<p>Nome: Mago Negro</p>
  	 * 	<p>Descricao: Mago definitivo no quesito ataque e defesa</p>
  	 * 	<p>Imagem: MagoNegro.jpg</p>
  	 	*<p>Tipo: fera</p>
		*<p>Atributo: terra</p>
		*<p>Nivel: 5</p>
		*<p>Ataque: 34443.0</p>
		*<p>Defesa: 2342.0</p>
  	 * @return retorna um String com todos os dados
  	 */
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getP());
		dados.append("\n");
		dados.append(this.getQ());
		return dados.toString();
	}
	
	
}
