package aplicacao;

public class Qualidade {
	
	//campos
	private String tipo;
	private String atributo;
	private int nivel;
	private double ataque;
	private double defesa;
	
	//construtores
	public Qualidade(String _tipo, String _atributo , int _nivel , double _ataque , double _defesa) {
		this.setAtaque(_ataque);
		this.setAtributo(_atributo);
		this.setDefesa(_defesa);
		this.setNivel(_nivel);
		this.setTipo(_tipo);
	}

	//metodos get
	public String getTipo() {
		return this.tipo;
	}
	
	public String getAtributo() {
		return this.atributo;
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public double getAtaque() {
		return this.ataque;
	}
	
	public double getDefesa() {
		return this.defesa;
	}

	//metodos set
	public void setTipo(String _tipo) {
		this.tipo = _tipo;
	}

	public void setAtributo(String _atributo) {
		this.atributo = _atributo;
	}

	public void setNivel(int _nivel) {
		this.nivel = _nivel;
	}

	public void setAtaque(double _ataque) {
		this.ataque = _ataque;
	}

	public void setDefesa(double _defesa) {
		this.defesa = _defesa;
	}
}