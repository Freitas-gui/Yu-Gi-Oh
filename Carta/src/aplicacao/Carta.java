package aplicacao;

public abstract class Carta {
	//campos
	private Perfil p;
	private Qualidade q;
	
	//construtores
	public Carta(Perfil _p , Qualidade _q) {
		
	}

	public Perfil getP() {
		return this.p;
	}
	
	public Qualidade getQ() {
		return this.q;
	}

	public void setP(Perfil _p) {
		this.p = _p;
	}

	public void setQ(Qualidade _q) {
		this.q = _q;
	}
	
	
}
