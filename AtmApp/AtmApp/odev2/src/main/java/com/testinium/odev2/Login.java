package com.testinium.odev2;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

	private JPanel frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 583);
		frame = new JPanel();
		frame.setBackground(new Color(0, 139, 139));
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel x = new JLabel("New label");
		x.setBounds(168, 11, 289, 262);
		ImageIcon imgIc = new ImageIcon(Register.class.getResource("./saving2.jpg"));
		Image img = imgIc.getImage();
		Image imgscale = img.getScaledInstance(x.getWidth(),x.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		x.setIcon(imgIc);
		frame.add(x);
		
		JPanel panel = new JPanel();
		panel.setBounds(168, 322, 289, 38);
		frame.add(panel);
		panel.setLayout(null);

		JTextField TC = new JTextField();
		TC.setBounds(0, 0, 289, 38);
		panel.add(TC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(168, 378, 289, 38);
		frame.add(panel_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBounds(0, 0, 289, 38);
		panel_1.add(passwordField);
		
		JButton Kayit = new JButton("Kayit Ol");
		Kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Register register =new Register();
				register.setVisible(true);
			}
		});
		Kayit.setBounds(168, 442, 143, 31);
		frame.add(Kayit);
		
		JButton Giris = new JButton("Giris");
		Giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc = TC.getText();
				char[] passw = passwordField.getPassword();

				if(tc.length() != 11 ){
					JOptionPane.showMessageDialog(null, "TC 11 haneli olmalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else if(passw.length < 6){
					JOptionPane.showMessageDialog(null, "Sifre en az 6 haneli olmalidir", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					DbConnection.connect();

					String query = "Select * from Persons where tc='" + tc +"' AND pass='" + passw +"'";
					ResultSet rs = DbConnection.select(query);
					try {
						if(rs.next()){

							setVisible(false);

							User_Main user_main=new User_Main(tc);
							user_main.setVisible(true);
						}

					} catch (SQLException throwables) {
						JOptionPane.showMessageDialog(null, "Kullanıcı bulunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
					}catch (NullPointerException throwables) {
						JOptionPane.showMessageDialog(null, "Kullanıcı bulunamadı - Null", "Hata", JOptionPane.ERROR_MESSAGE);
					}


					DbConnection.disconnect();

				}
			}
		});
		Giris.setBounds(314, 442, 143, 31);
		frame.add(Giris);
		
		JLabel lblNewLabel = new JLabel("     TC:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(112, 329, 46, 31);
		frame.add(lblNewLabel);
		
		JLabel lblSifre = new JLabel("     Sifre:");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSifre.setBounds(100, 385, 73, 31);
		frame.add(lblSifre);
	}

}
