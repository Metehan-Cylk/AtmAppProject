package com.testinium.odev2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField TC;
	private JPasswordField password;
	private JTextField mail;
	private JTextField telefon;
	private JTextField fullName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();

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
	public Register() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel x = new JLabel("New label");
		x.setBounds(208, 65, 199, 138);
		ImageIcon imgIc = new ImageIcon(Register.class.getResource("./saving2.jpg"));
		Image img = imgIc.getImage();
		Image imgscale = img.getScaledInstance(x.getWidth(),x.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		x.setIcon(imgIc);
		
		
		contentPane.add(x);

		JPanel name_panel = new JPanel();
		name_panel.setBounds(208, 232, 205, 24);
		contentPane.add(name_panel);
		name_panel.setLayout(null);

		fullName = new JTextField();
		fullName.setBounds(0, 0, 205, 24);
		name_panel.add(fullName);
		fullName.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(208, 267, 205, 24);
		contentPane.add(panel);
		panel.setLayout(null);

		TC = new JTextField();
		TC.setBounds(0, 0, 205, 24);
		panel.add(TC);
		TC.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(208, 302, 205, 24);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		password = new JPasswordField();
		password.setToolTipText("\r\npassword");
		password.setBounds(0, 0, 205, 24);
		panel_1.add(password);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(208, 337, 205, 24);
		contentPane.add(panel_2);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(0, 0, 205, 24);
		panel_2.add(mail);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(208, 372, 205, 24);
		contentPane.add(panel_2_1);
		
		telefon = new JTextField(); 
		telefon.setText("\r\n");
		telefon.setColumns(10);
		telefon.setBounds(0, 0, 205, 24);
		panel_2_1.add(telefon);
		
		JButton Kayitol = new JButton("Kayit Ol");
		Kayitol.setBackground(new Color(47, 79, 79));
		Kayitol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc = TC.getText();
				if(tc.length() != 11 ){
					JOptionPane.showMessageDialog(null, "TC 11 haneli olmalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else if(telefon.getText().length() == 0 || mail.getText().length() == 0 || password.getPassword().length == 0 || fullName.getText().length() == 0 ){
					JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz doldurunuz.", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else if(password.getPassword().length < 6){
					JOptionPane.showMessageDialog(null, "Sifre en az 6 haneli olmalidir", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {

					DbConnection.connect();
					System.out.println(password.getPassword());
					String query = "INSERT INTO Persons VALUES ('"+tc+"','"+password.getPassword()+"','"+fullName.getText()+"',0,'"+telefon.getText()+"')";
					DbConnection.update(query);


					DbConnection.disconnect();
					setVisible(false);

					User_Main user_main=new User_Main(tc);
					user_main.setVisible(true);
				}


			}
		});
		Kayitol.setBounds(208, 407, 205, 39);
		contentPane.add(Kayitol);


		JLabel FullName = new JLabel("Ad Soyad:");
		FullName.setFont(new Font("Tahoma", Font.BOLD, 13));
		FullName.setBounds(120, 232, 66, 24);
		contentPane.add(FullName);

		JLabel lblNewLabel = new JLabel("     TC:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(120, 267, 66, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblSifre = new JLabel("    Sifre:");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSifre.setBounds(120, 302, 66, 24);
		contentPane.add(lblSifre);
		
		JLabel lblMail = new JLabel("    Mail:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMail.setBounds(120, 337, 66, 24);
		contentPane.add(lblMail);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon:");
		lblTelefonNumaras.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefonNumaras.setBounds(120, 372, 66, 24);
		contentPane.add(lblTelefonNumaras);



		
	}
}
