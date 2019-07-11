package view;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

import implementacoes.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
public class TelaPrincipal {

	private JFrame frmYugioh;
	private JTextField txtSelecioneAsQualidade;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmYugioh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYugioh = new JFrame();
		frmYugioh.setTitle("Yu-Gi-Oh");
		frmYugioh.setForeground(new Color(240, 240, 240));
		frmYugioh.getContentPane().setBackground(new Color(240, 240, 240));
		frmYugioh.setBounds(100, 100, 682, 532);
		frmYugioh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYugioh.getContentPane().setLayout(null);
		
		//Inicializa o banco de dados bd 
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		
			
		//atributo{
		JLabel lblAtributo = new JLabel("Atributo:");
		lblAtributo.setForeground(Color.WHITE);
		lblAtributo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtributo.setBounds(10, 133, 78, 25);
		frmYugioh.getContentPane().add(lblAtributo);
		
		JRadioButton rdbtnFogo = new JRadioButton("Fogo");
		rdbtnFogo.setBounds(108, 133, 56, 23);
		frmYugioh.getContentPane().add(rdbtnFogo);
		
		
		JRadioButton rdbtnAgua = new JRadioButton("Agua");
		rdbtnAgua.setBounds(179, 133, 56, 23);
		frmYugioh.getContentPane().add(rdbtnAgua);
		
		JRadioButton rdbtnTerra = new JRadioButton("Terra");
		rdbtnTerra.setBounds(255, 135, 60, 23);
		frmYugioh.getContentPane().add(rdbtnTerra);
		
		JRadioButton rdbtnLuz = new JRadioButton("Luz");
		rdbtnLuz.setBounds(392, 135, 57, 23);
		frmYugioh.getContentPane().add(rdbtnLuz);
		
		JRadioButton rdbtnEscuridao = new JRadioButton("Escuridao");
		rdbtnEscuridao.setBounds(461, 135, 106, 23);
		frmYugioh.getContentPane().add(rdbtnEscuridao);
		
		JRadioButton rdbtnAr = new JRadioButton("Ar");
		rdbtnAr.setBounds(327, 135, 53, 23);
		frmYugioh.getContentPane().add(rdbtnAr);
		
		ButtonGroup groupAtributo = new ButtonGroup();
		groupAtributo.add(rdbtnFogo);
		groupAtributo.add(rdbtnAgua);
		groupAtributo.add(rdbtnTerra);
		groupAtributo.add(rdbtnLuz);
		groupAtributo.add(rdbtnEscuridao);
		groupAtributo.add(rdbtnAr);
		
		
		
		//}atributo
		//Tipo{
		JLabel LTipo = new JLabel("Tipo:");
		LTipo.setForeground(Color.WHITE);
		LTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LTipo.setBounds(10, 80, 65, 25);
		frmYugioh.getContentPane().add(LTipo);
		
		JRadioButton rdbtnGuerreiro = new JRadioButton("Guerreiro");
		rdbtnGuerreiro.setBackground(Color.WHITE);
		rdbtnGuerreiro.setBounds(108, 82, 90, 23);
		frmYugioh.getContentPane().add(rdbtnGuerreiro);
		
		JRadioButton rdbtnDragao = new JRadioButton("Dragao");
		rdbtnDragao.setBounds(210, 82, 83, 23);
		frmYugioh.getContentPane().add(rdbtnDragao);
		
		JRadioButton rdbtnBesta = new JRadioButton("Besta");
		rdbtnBesta.setBounds(305, 82, 63, 23);
		frmYugioh.getContentPane().add(rdbtnBesta);
		
		JRadioButton rdbtnReptil = new JRadioButton("Reptil");
		rdbtnReptil.setBounds(386, 82, 75, 23);
		frmYugioh.getContentPane().add(rdbtnReptil);
		
		JRadioButton rdbtnRocha = new JRadioButton("Rocha");
		rdbtnRocha.setBounds(473, 82, 74, 23);
		frmYugioh.getContentPane().add(rdbtnRocha);
		
		JRadioButton rdbtnMago = new JRadioButton("Mago");
		rdbtnMago.setBounds(559, 82, 75, 23);
		frmYugioh.getContentPane().add(rdbtnMago);
		
		ButtonGroup groupTipo = new ButtonGroup();
		groupTipo.add(rdbtnGuerreiro);
		groupTipo.add(rdbtnDragao);
		groupTipo.add(rdbtnBesta);
		groupTipo.add(rdbtnReptil);
		groupTipo.add(rdbtnRocha);
		groupTipo.add(rdbtnMago);
		
		
		//}tipo
		
		//Nivel{
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNivel.setBounds(10, 186, 65, 25);
		frmYugioh.getContentPane().add(lblNivel);
		
		JRadioButton rdbtn1 = new JRadioButton("1");
		rdbtn1.setBounds(63, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("2");
		rdbtn2.setBounds(110, 186, 43, 23);
		frmYugioh.getContentPane().add(rdbtn2);
		
		JRadioButton rdbtn3 = new JRadioButton("3");
		rdbtn3.setBounds(160, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn3);
		
		JRadioButton rdbtn4 = new JRadioButton("4");
		rdbtn4.setBounds(205, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn4);
		
		JRadioButton rdbtn5 = new JRadioButton("5");
		rdbtn5.setBounds(250, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn5);
		
		JRadioButton rdbtn6 = new JRadioButton("6");
		rdbtn6.setBounds(300, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn6);
		
		JRadioButton rdbtn12 = new JRadioButton("12");
		rdbtn12.setBounds(600, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn12);
		
		JRadioButton rdbtn11 = new JRadioButton("11");
		rdbtn11.setBounds(550, 186, 42, 23);
		frmYugioh.getContentPane().add(rdbtn11);
		
		JRadioButton rdbtn10 = new JRadioButton("10");
		rdbtn10.setBounds(500, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn10);
		
		JRadioButton rdbtn9 = new JRadioButton("9");
		rdbtn9.setBounds(450, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn9);
		
		JRadioButton rdbtn8 = new JRadioButton("8");
		rdbtn8.setBounds(400, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn8);
		
		JRadioButton rdbtn7 = new JRadioButton("7");
		rdbtn7.setBounds(350, 186, 41, 23);
		frmYugioh.getContentPane().add(rdbtn7);
		
		ButtonGroup groupNivel = new ButtonGroup();
		groupNivel.add(rdbtn1);
		groupNivel.add(rdbtn2);
		groupNivel.add(rdbtn3);
		groupNivel.add(rdbtn4);
		groupNivel.add(rdbtn5);
		groupNivel.add(rdbtn6);
		groupNivel.add(rdbtn7);
		groupNivel.add(rdbtn8);
		groupNivel.add(rdbtn9);
		groupNivel.add(rdbtn10);
		groupNivel.add(rdbtn11);
		groupNivel.add(rdbtn12);
		
		//}Nivel
		//Ataque{
		JLabel lblAtaque = new JLabel("Ataque:");
		lblAtaque.setForeground(Color.WHITE);
		lblAtaque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtaque.setBounds(10, 237, 85, 25);
		
		frmYugioh.getContentPane().add(lblAtaque);
		JSpinner atkMax = new JSpinner();
		atkMax.setModel(new SpinnerNumberModel(new Integer(99999), new Integer(0), null, new Integer(1)));
		atkMax.setBounds(367, 237, 82, 29);
		frmYugioh.getContentPane().add(atkMax);
		
		JSpinner atkMin = new JSpinner();
		atkMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		atkMin.setBounds(170, 237, 83, 29);
		frmYugioh.getContentPane().add(atkMin);
				
		JLabel lblAtkMaiorQ = new JLabel("Maior que:");
		lblAtkMaiorQ.setForeground(Color.WHITE);
		lblAtkMaiorQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtkMaiorQ.setBounds(98, 244, 76, 14);
		frmYugioh.getContentPane().add(lblAtkMaiorQ);
				
		JLabel lblAtkMenorQ = new JLabel("Menor que:");
		lblAtkMenorQ.setForeground(Color.WHITE);
		lblAtkMenorQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtkMenorQ.setBounds(290, 244, 78, 14);
		frmYugioh.getContentPane().add(lblAtkMenorQ);
		
		JLabel lblAtkIgual = new JLabel("Igual:");
		lblAtkIgual.setForeground(Color.WHITE);
		lblAtkIgual.setBounds(492, 244, 55, 16);
		frmYugioh.getContentPane().add(lblAtkIgual);
		
		JSpinner atkIgual = new JSpinner();
		atkIgual.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		atkIgual.setBounds(543, 237, 83, 29);
		frmYugioh.getContentPane().add(atkIgual);
		
		//}Ataque
		
		//Defesa{
		JLabel lblDefesa = new JLabel("Defesa:");
		lblDefesa.setForeground(Color.WHITE);
		lblDefesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDefesa.setBounds(10, 293, 78, 25);
		frmYugioh.getContentPane().add(lblDefesa);
		
		JSpinner defMin = new JSpinner();
		defMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defMin.setBounds(175, 295, 78, 29);
		frmYugioh.getContentPane().add(defMin);
		
		JLabel lblDefMaiorQ = new JLabel("Maior que:");
		lblDefMaiorQ.setForeground(Color.WHITE);
		lblDefMaiorQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDefMaiorQ.setBounds(98, 300, 78, 14);
		frmYugioh.getContentPane().add(lblDefMaiorQ);
		
		JSpinner defMax = new JSpinner();
		defMax.setModel(new SpinnerNumberModel(new Integer(99999), new Integer(0), null, new Integer(1)));
		defMax.setBounds(367, 293, 82, 29);
		frmYugioh.getContentPane().add(defMax);
	
		
		JLabel lblDefMenorQ = new JLabel("Menor que:");
		lblDefMenorQ.setForeground(Color.WHITE);
		lblDefMenorQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDefMenorQ.setBounds(284, 300, 76, 14);
		frmYugioh.getContentPane().add(lblDefMenorQ);
		
		JLabel lblDefIgual = new JLabel("Igual:");
		lblDefIgual.setForeground(Color.WHITE);
		lblDefIgual.setBounds(492, 300, 55, 16);
		frmYugioh.getContentPane().add(lblDefIgual);
		
		JSpinner defIgual = new JSpinner();
		defIgual.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defIgual.setBounds(543, 294, 83, 29);
		frmYugioh.getContentPane().add(defIgual);
		//}Defesa
		
		//pesquisar
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//valores para realizar busca de de cartas que possui os valores de qualidade preenchidas na interface grafica e seus respectvos defaults 
				String tipo=null , atributo=null , nivel=null , ataqueMax=null , ataqueMin=null , defesaMax=null , defesaMin=null;
				
				//tipo recebe o texto do botao de radio selecionado do grupo tipo
				if(rdbtnGuerreiro.isSelected())
					tipo=rdbtnGuerreiro.getText();
				else if(rdbtnDragao.isSelected())
					tipo=rdbtnDragao.getText();
				else if(rdbtnBesta.isSelected())
					tipo=rdbtnBesta.getText();
				else if(rdbtnReptil.isSelected())
					tipo=rdbtnReptil.getText();
				else if(rdbtnRocha.isSelected())
					tipo=rdbtnRocha.getText();
				else if(rdbtnMago.isSelected())
					tipo=rdbtnMago.getText();
				//atributo recebe o texto do butao de radio selecionado do grupo atributo
				if(rdbtnFogo.isSelected())
					atributo=rdbtnFogo.getText();
				else if(rdbtnAgua.isSelected())
					atributo=rdbtnAgua.getText();
				else if(rdbtnTerra.isSelected())
					atributo=rdbtnTerra.getText();
				else if(rdbtnLuz.isSelected())
					atributo=rdbtnLuz.getText();
				else if(rdbtnEscuridao.isSelected())
					atributo=rdbtnEscuridao.getText();
				else if(rdbtnAr.isSelected())
					atributo=rdbtnAr.getText();
				//nivel recebe o texto do butao de radio selecionado do grupo nivel
				if(rdbtn1.isSelected())
					nivel=rdbtn1.getText();
				else if(rdbtn2.isSelected())
					nivel=rdbtn2.getText();
				else if(rdbtn3.isSelected())
					nivel=rdbtn3.getText();
				else if(rdbtn4.isSelected())
					nivel=rdbtn4.getText();
				else if(rdbtn5.isSelected())
					nivel=rdbtn5.getText();
				else if(rdbtn6.isSelected())
					nivel=rdbtn6.getText();
				else if(rdbtn7.isSelected())
					nivel=rdbtn7.getText();
				else if(rdbtn8.isSelected())
					nivel=rdbtn8.getText();
				else if(rdbtn9.isSelected())
					nivel=rdbtn9.getText();
				else if(rdbtn10.isSelected())
					nivel=rdbtn10.getText();
				else if(rdbtn11.isSelected())
					nivel=rdbtn11.getText();
				else if(rdbtn12.isSelected())
					nivel=rdbtn12.getText();
				
				//ataque recebe o valor digitado dentro do spiner
				
				ataqueMax=atkMax.getValue().toString();
				ataqueMin=atkMin.getValue().toString();
				//defesa recebe o valor digitado dentro do spiner
				defesaMin=defMin.getValue().toString();
				defesaMax=defMax.getValue().toString();
				//Cria um objeto Qualidade que recebe os valores a cima e sera ultilizado para registrar uma nova carta
				//carts=bd.busca(tipo , atributo , nivel , ataqueMax , ataqueMin , defesaMax , defesaMin);
				/*Qualidade pesquisaQualidade = new Qualidade("Mago","Fogo",3,44,55);
				Perfil pesquisaPerfil = new Perfil("quikfit","creatividade em sua jornada de arqueiro");
				Carta cart = new Carta(pesquisaPerfil,pesquisaQualidade);
				new TelaCarta(cart).setVisible(true);*/

				try {
					ResultSet carts = null;
					carts=bd.busca(tipo , atributo, nivel , ataqueMax , ataqueMin , defesaMax , defesaMin);
					while(carts.next()) {
						System.out.println("certo");
						//cria uma cartaAuxiliar, sem registrala no Banco de Dados, e retorna para a tela de exibicao TelaCarta
						
						//Qualidade
						String pTipo = carts.getString("tipo");
						String pAtributo = carts.getString("atributo");
						int pNivel =  Integer.parseInt(carts.getString("nivel"));
						double pAtaque = Double.parseDouble(carts.getString("ataque"));
						double pDefesa = Double.parseDouble(carts.getString("defesa"));
						Qualidade pesquisaQualidade = new Qualidade(pTipo, pAtributo, pNivel, pAtaque, pDefesa);
								
						//Perfil
						String pNome = carts.getString("nome");
						String pDescricao = carts.getString("descricao");
						String pImagem = carts.getString("imagem");
						System.out.println(pImagem);
						
						Perfil pesquisaPerfil = new Perfil(pNome,pDescricao,pImagem);
						
						//carta
						Carta cart = new Carta(pesquisaPerfil,pesquisaQualidade);
						
						//
						new TelaCarta(cart).setVisible(true);
					}
				}catch(Exception e) {e.printStackTrace();}
			}
		});
		btnPesquisar.setBounds(10, 357, 200, 100);
		frmYugioh.getContentPane().add(btnPesquisar);
		
		//registrar
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//valores para registrar as qualidades de uma carta e seus respectvos defaults 
				String tipo="Indefinido",atributo="Indefinido";
				int nivel=0;
				double ataque,defesa;
				
				//tipo recebe o texto do butao de radio selecionado do grupo tipo
				if(rdbtnGuerreiro.isSelected())
					tipo=rdbtnGuerreiro.getText();
				else if(rdbtnDragao.isSelected())
					tipo=rdbtnDragao.getText();
				else if(rdbtnBesta.isSelected())
					tipo=rdbtnBesta.getText();
				else if(rdbtnReptil.isSelected())
					tipo=rdbtnReptil.getText();
				else if(rdbtnRocha.isSelected())
					tipo=rdbtnRocha.getText();
				else if(rdbtnMago.isSelected())
					tipo=rdbtnMago.getText();
				//atributo recebe o texto do butao de radio selecionado do grupo atributo
				if(rdbtnFogo.isSelected())
					atributo=rdbtnFogo.getText();
				else if(rdbtnAgua.isSelected())
					atributo=rdbtnAgua.getText();
				else if(rdbtnTerra.isSelected())
					atributo=rdbtnTerra.getText();
				else if(rdbtnLuz.isSelected())
					atributo=rdbtnLuz.getText();
				else if(rdbtnEscuridao.isSelected())
					atributo=rdbtnEscuridao.getText();
				else if(rdbtnAr.isSelected())
					atributo=rdbtnAr.getText();
				//nivel recebe o texto do butao de radio selecionado do grupo nivel
				if(rdbtn1.isSelected())
					nivel=Integer.parseInt(rdbtn1.getText());
				else if(rdbtn2.isSelected())
					nivel=Integer.parseInt(rdbtn2.getText());
				else if(rdbtn3.isSelected())
					nivel=Integer.parseInt(rdbtn3.getText());
				else if(rdbtn4.isSelected())
					nivel=Integer.parseInt(rdbtn4.getText());
				else if(rdbtn5.isSelected())
					nivel=Integer.parseInt(rdbtn5.getText());
				else if(rdbtn6.isSelected())
					nivel=Integer.parseInt(rdbtn6.getText());
				else if(rdbtn7.isSelected())
					nivel=Integer.parseInt(rdbtn7.getText());
				else if(rdbtn8.isSelected())
					nivel=Integer.parseInt(rdbtn8.getText());
				else if(rdbtn9.isSelected())
					nivel=Integer.parseInt(rdbtn9.getText());
				else if(rdbtn10.isSelected())
					nivel=Integer.parseInt(rdbtn10.getText());
				else if(rdbtn11.isSelected())
					nivel=Integer.parseInt(rdbtn11.getText());
				else if(rdbtn12.isSelected())
					nivel=Integer.parseInt(rdbtn12.getText());
				
				//ataque recebe o valor digitado dentro do spiner
				ataque=(Integer.parseInt(atkIgual.getValue().toString()));
				//defesa recebe o valor digitado dentro do spiner
				defesa=(Integer.parseInt(defIgual.getValue().toString()));
				//Cria um objeto Qualidade que recebe os valores a cima e sera ultilizado para registrar uma nova carta
				Qualidade qualidadeRegistrada = new Qualidade(tipo,atributo,nivel,ataque,defesa);
				if(tipo=="Indefinido" || atributo=="Indefinido" || nivel==0)
					new Alerta().setVisible(true);
				else
					new TelaInsereImagem(qualidadeRegistrada,bd).setVisible(true);
				
				
			}
		});
		
		btnRegistrar.addMouseListener(new MouseAdapter() {
			
			//colocar nova janela
			});
		btnRegistrar.setBounds(232, 357, 200, 100);
		frmYugioh.getContentPane().add(btnRegistrar);
		
		//visualizarDeck
		JButton btnVisualizarDeck = new JButton("Visualizar Deck");
		btnVisualizarDeck.setBounds(461, 357, 200, 100);
		frmYugioh.getContentPane().add(btnVisualizarDeck);
		
		txtSelecioneAsQualidade = new JTextField();
		txtSelecioneAsQualidade.setEditable(false);
		txtSelecioneAsQualidade.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		txtSelecioneAsQualidade.setText("Selecione as qualidade das Cartas");
		txtSelecioneAsQualidade.setBounds(91, 6, 485, 61);
		frmYugioh.getContentPane().add(txtSelecioneAsQualidade);
		txtSelecioneAsQualidade.setColumns(10);
		
		JLabel imgFundo = new JLabel("New label");
		imgFundo.setIcon(new ImageIcon("C:\\Users\\CB\\Desktop\\Fundo_Yugioh(2).png"));
		imgFundo.setBounds(0, 0, 661, 457);
		frmYugioh.getContentPane().add(imgFundo);
		
		JMenuBar menuBar = new JMenuBar();
		frmYugioh.setJMenuBar(menuBar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groupTipo.clearSelection();
				groupAtributo.clearSelection();
				groupNivel.clearSelection();
				atkMax.setValue(99999);
				atkMin.setValue(0);
				atkIgual.setValue(0);
				defMax.setValue(99999);
				defMin.setValue(0);
				defIgual.setValue(0);
				
			}
		});
		menuBar.add(btnAtualizar);
		
		
		
		
	}
}
