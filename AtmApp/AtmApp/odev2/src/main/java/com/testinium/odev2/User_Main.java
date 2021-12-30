package com.testinium.odev2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Main frame = new User_Main("1478526987");
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
	public User_Main(String TC) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sayin ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 60, 27);
		contentPane.add(lblNewLabel);
		
		JLabel isim = new JLabel("Sayin ");
		isim.setFont(new Font("Tahoma", Font.BOLD, 14));
		isim.setBounds(57, 11, 156, 27);
		isim.setText(TC);
		contentPane.add(isim);
		
		JLabel text = new JLabel("Lutfen Yapmak Istediginiz Islemi Seciniz");
		text.setFont(new Font("Tahoma", Font.BOLD, 14));
		text.setBounds(10, 39, 298, 27);
		contentPane.add(text);
		
		JButton Para_yatir = new JButton("Para Yatir");
		Para_yatir.setBackground(new Color(47, 79, 79));
		Para_yatir.setFont(new Font("Tahoma", Font.BOLD, 16));
		Para_yatir.setBounds(154, 135, 223, 47);
		contentPane.add(Para_yatir);
		
		JButton Para_cek = new JButton("Para Cek");
		Para_cek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Para_cek.setFont(new Font("Tahoma", Font.BOLD, 16));
		Para_cek.setBackground(new Color(47, 79, 79));
		Para_cek.setBounds(154, 205, 223, 47);
		contentPane.add(Para_cek);
		
		JButton Para_gonder = new JButton("Para Gonder");
		Para_gonder.setFont(new Font("Tahoma", Font.BOLD, 16));
		Para_gonder.setBackground(new Color(47, 79, 79));
		Para_gonder.setBounds(154, 275, 223, 47);
		contentPane.add(Para_gonder);
	}

}
