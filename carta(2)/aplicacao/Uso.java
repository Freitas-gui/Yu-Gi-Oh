package aplicacao;
import view.*;
import implementacoes.*;
import implementacoes.*;
public class Uso {
	public static void main(String args[]) {
		
		BancoDeDados bd = new BancoDeDados();
		
		//testa to string 
		Qualidade q = new Qualidade("fera", "terra",5,34443,2342);
		//Perfil p = new Perfil("MAGGO NEGRO", "BRUXAO Q ROUBA SUA ALMA","maguu.jpg");
		//Carta c =new Carta(p,q);
		System.out.println(q);
		
		
		//bd.conectar();
		//bd.inserirQualidade("drag", "fogo", 3,42 ,244);
		//bd.listarQualidade();
		//bd.listarPerfil();
		//System.out.println("\n");
		//bd.listarQualidade();
		//System.out.println("\n");
		//bd.DeletarPerfil("3");
		//bd.DeletarQualidade("3");
		//bd.DeletarCarta("3");
		//bd.listarCarta();
		
		/*if(bd.estaConectado())
			System.out.println("yees");
		else
			System.out.println("noou");
		//bd.listarQualidade();
		//System.out.println("\n");
		//bd.listarPerfil();
		//bd.inserirQualidade("fera", "terra",5,34443,2342);
		System.out.println("\n");
		//bd.DeletarPerfil("3");
		//bd.DeletarQualidade("3");
		System.out.println("\n");
		//bd.inserirPerfil("Mago Negro", "pode pah");
		//bd.inserirCarta("MAGGO NEGRO", "BRUXAO Q ROUBA SUA ALMA", "Mago", "Escuridao", 10, 999999, 74643);
		//bd.listarPerfil();
		bd.listarQualidade();
		//bd.listarPerfil();
		//bd.listarQualidade();
		bd.listarCarta();
		bd.desconectar();
		*/
		//bd.desconectar();


		

	}
}
