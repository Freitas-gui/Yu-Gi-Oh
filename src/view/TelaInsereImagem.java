package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import implementacoes.*;
import javafx.stage.FileChooser;

import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TelaInsereImagem extends JDialog {
	private File imagemPasta;
	private String imagemSalva;
	private Panel panel = new Panel();
	private JLabel image = new JLabel("");
	private final JLabel lblNome = new JLabel("Nome:");
	private JTextField txtNome;
	//private byte[] imagemRegistrada;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,Qualidade qualidadeAux,BancoDeDados bd) {
		try {
			TelaInsereImagem dialog = new TelaInsereImagem(qualidadeAux , bd);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaInsereImagem(Qualidade qualidadeAux,BancoDeDados bd) {
		setBounds(100, 100, 494, 410);
		getContentPane().setLayout(null);
		{
			
			panel.setBounds(10, 86, 213, 275);
			getContentPane().add(panel);
			panel.setLayout(null);
		}
		{
			
			image.setBounds(0, 0, 213, 275);
			panel.add(image);
		}
		
		
		
		
		
		
		{
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNome.setBounds(24, 11, 74, 21);
			getContentPane().add(lblNome);
		}
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(108, 13, 316, 20);
		getContentPane().add(txtNome);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(249, 142, 198, 168);
		getContentPane().add(txtDescricao);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescricao.setBounds(249, 90, 95, 29);
		getContentPane().add(lblDescricao);
		{
			JLabel indicaImagem = new JLabel("Imagem:");
			indicaImagem.setFont(new Font("Tahoma", Font.BOLD, 15));
			indicaImagem.setBounds(10, 61, 88, 21);
			getContentPane().add(indicaImagem);
		}
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imagemPasta = selecionarImagem();
				imagemSalva=imagemPasta.getName();
				abrirImagem(imagemPasta);
			}
		});
		
		btnAbrir.setBounds(255, 338, 89, 23);
		getContentPane().add(btnAbrir);
		{
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					String tipo=(qualidadeAux.getTipo());
					String atributo=(qualidadeAux.getAtributo());
					int nivel=(qualidadeAux.getNivel());
					double ataque=(qualidadeAux.getAtaque());
					double defesa=(qualidadeAux.getDefesa());
					
					String nome=(txtNome.getText());
					String descricao=(txtDescricao.getText());
					//byte [] imagem=(getImagem());
					//String imagem = imagemPasta.ge();
				
					//System.out.println(imagem);
					
					
					//System.out.println(imagem);

					Qualidade qualidadeRegistrada = new Qualidade(tipo,atributo,nivel,ataque,defesa);
					Perfil perfilregistrado = new Perfil(nome,descricao,imagemSalva);
					
					//System.out.println("\n");
					System.out.printf(perfilregistrado.getImagem());
					Carta cartaRegistrada = new Carta(perfilregistrado,qualidadeRegistrada);
					
					//imagemRegistrada = imagem;
					
					bd.inserirCarta(cartaRegistrada);
					//System.out.println("   ");
					//bd.listarPerfil();
					
					dispose();
				}
			});
			btnSalvar.setBounds(358, 338, 89, 23);
			getContentPane().add(btnSalvar);
		}
	}
	
	public File selecionarImagem(){
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG" , "jpg","png");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setCurrentDirectory(new File("/"));
		fileChooser.showOpenDialog(this);
		
		return fileChooser.getSelectedFile();
	}
	
	private byte[] getImagem() {
		boolean isPng = false;
		if(imagemPasta !=null) {
			isPng = imagemPasta.getName().endsWith("png");
			try{
				BufferedImage image = ImageIO.read(imagemPasta);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int type = BufferedImage.TYPE_INT_RGB;
				if(isPng) {
					type = BufferedImage.BITMASK;
				}
				BufferedImage novaImagem = new BufferedImage(panel.getWidth()-5, panel.getHeight()-5, type);
				Graphics2D g = novaImagem.createGraphics();
				g.setComposite(AlphaComposite.Src);
				g.drawImage(image, 0, 0, panel.getWidth()-5,panel.getHeight()-5,null);
				
				if(isPng) 
					ImageIO.write(novaImagem, "png", out);
				else
					ImageIO.write(novaImagem, "jpg", out);
				out.flush();
				byte[] byteArray = out.toByteArray();
				out.close();
				
				return byteArray;
			}catch(IOException e) {e.printStackTrace();}
		}
		return null;
	}	
	
	private void abrirImagem(Object source) {
		if (source instanceof File) {
			ImageIcon icon = new ImageIcon("C:\\Users\\CB\\Desktop\\imagensYugioh\\"+imagemSalva);
			icon.setImage(icon.getImage().getScaledInstance(panel.getWidth()-5,panel.getHeight()-5,100));
			image.setIcon(icon);
		}else if(source instanceof byte []) {
			//ImageIcon icon = new ImageIcon(imagemRegistrada);
			//icon.setImage(icon.getImage().getScaledInstance(panel.getWidth()-5,panel.getHeight()-5,100));
			//image.setIcon(icon);
		}
	}
	
	
	
}
