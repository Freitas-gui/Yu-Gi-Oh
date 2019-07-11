package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alerta extends JFrame {

	private JPanel Alerta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alerta frame = new Alerta();
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
	public Alerta() {
		setTitle("Alerta!");
		setBounds(100, 100, 341, 169);
		Alerta = new JPanel();
		Alerta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Alerta);
		Alerta.setLayout(null);
		
		JLabel lblPreenchaTodosOs = new JLabel("Preencha todos os campos!!!");
		lblPreenchaTodosOs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPreenchaTodosOs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaTodosOs.setBounds(10, 57, 297, 29);
		Alerta.add(lblPreenchaTodosOs);
		
		JLabel nRegistrou = new JLabel("N\u00E3o registrou");
		nRegistrou.setHorizontalAlignment(SwingConstants.CENTER);
		nRegistrou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nRegistrou.setBounds(10, 17, 297, 29);
		Alerta.add(nRegistrou);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(114, 97, 89, 23);
		Alerta.add(btnOk);
	}
}
