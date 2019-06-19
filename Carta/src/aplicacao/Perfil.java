package aplicacao;

public class Perfil {
	//campos
	private String nome;
	private String descricao;
	//falta a imagem
	
	//construtores
	public Perfil(String _nome , String _descricao/*, buffer _Imagem*/) {
		this.setNome(_nome);
		this.setDescricao(_descricao);
	}

	
	//metodos get
	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	
	//metodos set
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
