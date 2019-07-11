package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementacoes.BancoDeDados;
import implementacoes.Carta;
import implementacoes.Perfil;
import implementacoes.Qualidade;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.Label;

public class TelaCarta extends JFrame {

	private JPanel contentPane;
	
	private enum lado{
		esquerdo,direito;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args , Carta cart) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarta frame = new TelaCarta(cart);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCarta(Carta cart) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 306, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		
		JLabel lblNome = new JLabel("Nome\r\n");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(0, 6, 330, 23);
		contentPane.add(lblNome);
		lblNome.setText(""+cart.getP().getNome());
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 93, 82, 23);
		contentPane.add(lblTipo);
		
		JLabel lblAtributo = new JLabel("Atributo\r\n:");
		lblAtributo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtributo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtributo.setBounds(10, 145, 82, 23);
		contentPane.add(lblAtributo);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNivel.setBounds(10, 198, 82, 23);
		contentPane.add(lblNivel);
		
		JLabel lblAtaque = new JLabel("Ataque:\r\n");
		lblAtaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtaque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtaque.setBounds(10, 246, 82, 23);
		contentPane.add(lblAtaque);
		
		JLabel lblDefesa = new JLabel("Defesa:");
		lblDefesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDefesa.setBounds(10, 292, 82, 23);
		contentPane.add(lblDefesa);
		
		JLabel _Tipo = new JLabel("Tipo");
		_Tipo.setHorizontalAlignment(SwingConstants.CENTER);
		_Tipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		_Tipo.setBounds(112, 93, 218, 23);
		contentPane.add(_Tipo);
		_Tipo.setText(cart.getQ().getTipo());
		
		JLabel _Atributo = new JLabel("Atributo\r\n");
		_Atributo.setHorizontalAlignment(SwingConstants.CENTER);
		_Atributo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		_Atributo.setBounds(112, 145, 212, 23);
		contentPane.add(_Atributo);
		_Atributo.setText(cart.getQ().getAtributo());
		
		JLabel _Nivel = new JLabel("Nivel");
		_Nivel.setHorizontalAlignment(SwingConstants.CENTER);
		_Nivel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		_Nivel.setBounds(112, 198, 218, 23);
		contentPane.add(_Nivel);
		_Nivel.setText(""+cart.getQ().getNivel());
		
		JLabel _Ataque = new JLabel("Ataque\r\n");
		_Ataque.setHorizontalAlignment(SwingConstants.CENTER);
		_Ataque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		_Ataque.setBounds(112, 246, 218, 23);
		contentPane.add(_Ataque);
		_Ataque.setText(""+cart.getQ().getAtaque());
		
		JLabel _Defesa = new JLabel("Defesa");
		_Defesa.setHorizontalAlignment(SwingConstants.CENTER);
		_Defesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		_Defesa.setBounds(112, 292, 218, 23);
		contentPane.add(_Defesa);
		_Defesa.setText(""+cart.getQ().getDefesa());
		
		JTextArea _Descricao = new JTextArea();
		_Descricao.setEditable(false);
		_Descricao.setBounds(40, 332, 234, 111);
		contentPane.add(_Descricao);
		_Descricao.setText(""+cart.getP().getDescricao());
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 295, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setBounds(0, 0, 295, 443);
		panel.add(lblImagem);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\CB\\Desktop\\imagensYugioh\\"+cart.getP().getImagem());
		icon.setImage(icon.getImage().getScaledInstance(panel.getWidth()-5,panel.getHeight()-5,100));
		lblImagem.setIcon(icon);
		
		
		
		
	}
}
