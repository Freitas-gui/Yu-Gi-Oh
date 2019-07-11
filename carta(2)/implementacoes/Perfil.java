package implementacoes;
/**
 * A classe: <b>Perfil</b> possui respectivamente 3 campos: nome,descricao e imagem. A classe Perfil e ultilizada na estrutura da classe Carta, para definir caracteristicas unicas
 * de um objeto Carta, essas caracteristicas sao o nome, uma descricao breve e uma imagem da Carta
 *  *
 * @author Guilherme F. | Ualaci .A | Gustavo .B | Joao Marcos .P | Kaio .A   
 * @version 1.0 (Junho-2019)
 */

public class Perfil {
	
	/** nome especifico da Carta */
	private String nome;
	/** descricao especifica da Carta */
	private String descricao;
	/**imagem especifica da Carta*/
	private String imagem;

	
	/**
  	 * construtor para inicializar valores nos campos
  	 *
  	 * @param _nome nome da Carta
  	 * @param _descricao descricaoda Carta
  	 * @param _imagem imagem da Carta
  	 */
	public Perfil(String _nome , String _descricao,String _imagem) {
		this.setNome(_nome);
		this.setDescricao(_descricao);
		this.setImagem(_imagem);
	}
	
	/**
  	 * construtor para inicializar valores nos campos e inserir o Perfil em um banco de dados
  	 *
  	 * @param _nome nome da Carta
  	 * @param _descricao descricaoda da Carta
  	 * @param _imagem imagem da Carta
  	 * @param bd Banco de dados que armazena o Perfil da Carta
  	 */
	public Perfil(BancoDeDados bd , String _nome , String _descricao , String _imagem) {
		this(_nome,_descricao,_imagem);
		bd.inserirPerfil(_nome , _descricao , _imagem);
	}


	/**
  	 * pega o nome
  	 *
  	 * @return nome
  	 */
	public String getNome() {
		return this.nome;
	}

	/**
  	 * pega a descricao
  	 *
  	 * @return descricao
  	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
  	 * pega a imagem
  	 *
  	 * @return imagem
  	 */
	public String getImagem() {
		return this.imagem;
	}
	
	/**
  	 * modifica o campo nome 
  	 * 
  	 * @param _nome novo nome da Carta
  	 */
	public void setNome(String _nome) {
		this.nome = _nome;
	}

	/**
	 * modifica o campo descricao
	 * 
	 * @param _descricao nova descricao da Carta
  	 */
	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}

	/** 
	 *  modifica o campo imagem
	 * 
	 * 
	 * @param _imagem nova imagem da Carta
	 * 
  	 */
	public void setImagem(String _imagem) {
		this.imagem = _imagem;
	}
	
	
	/**Metodo compara dois objetos Perfil e verifica se sao iguais
	 * 
	 * @param p perfil a ser comparado
	 * 
	 * @return boolean , true se todos os campos forem iguais e false se todos os campos forem diferentes
	 * */
	public boolean equals(Perfil p) {
		if (this.getNome()==p.getNome() && this.getDescricao()==p.getDescricao() && this.getImagem()==p.getImagem())
			return true;
		else 
			return false;
	}

	/**Metodo compara dois objetos Perfil e verifica qual e maior, ultilizando a soma do tamanho das
	 * Strings nome+descricao+imagem como criterio de verificacao
	 * 
	 * @param p perfil a ser comparado
	 *
	 * @return inteiro, 1 se maior, -1 se menor ou 0 se igual
	 * */
	public int compareTo(Perfil p) {
		int tamanho1 = this.getNome().length() + this.getDescricao().length() + this.getImagem().length();
		int tamanho2 = p.getNome().length() + p.getDescricao().length() + p.getImagem().length();
		if( tamanho1>tamanho2)
			return 1;
		else if(tamanho1<tamanho2)
			return -1;
		else
			return 0;
	}
	/**
  	 * Sobreposição do método toString para retornar todo o conteúdo do Perfil
  	 * <p>Exemplo: </p>
  	 * 		<p>Nome: Mago Negro</p>
  	 * 		<p>Descricao: Mago definitivo no quesito ataque e defesa</p>
  	 * 		<p>Imagem: MagoNegro.jpg</p>
  	 * @return retorna um String com todos os dados
  	 */
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("Nome: ");
		dados.append(this.getNome());
		dados.append("\nDescricao: ");
		dados.append(this.getDescricao());
		dados.append("\nImagem: ");
		dados.append(this.getImagem());
		return dados.toString();
	}
}
