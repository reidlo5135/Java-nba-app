package com.app.nba.view;

import com.app.nba.model.user.MemberDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class ModifyPanel extends JPanel{
	static MemberDAO dao = new MemberDAO();
	
	public ModifyPanel() {
		setView();
		setSize(550, 800);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
	}
	
	void setView() {
		URL imgURL = LoginPanel.class.getResource("/img/logo.png");
		System.out.println(imgURL);
		ImageIcon imgIcon = new ImageIcon(imgURL);
		JLabel logo = new JLabel(imgIcon);
		logo.setSize(250, 250);
		logo.setLayout(null);
		logo.setBounds(140, 100, 250, 250);
		add(logo);
		
		JLabel label_ID = new JLabel("ID");
		label_ID.setBounds(135, 380, 125, 30);
		Font font = new Font("휴먼모음T", Font.BOLD, 15);
		label_ID.setFont(font);
		label_ID.setForeground(Color.WHITE);
		add(label_ID);
		
		JTextField tf_ID = new JTextField();
		tf_ID.setBounds(135, 405, 260, 20);
		add(tf_ID);
		
		JLabel label_PW = new JLabel("PW");
		label_PW.setBounds(135, 435, 125, 30);
		label_PW.setFont(font);
		label_PW.setForeground(Color.WHITE);
		add(label_PW);
		
		JPasswordField tf_PW = new JPasswordField();
		tf_PW.setBounds(135, 465, 260, 20);
		tf_PW.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Main.movePanel(1);
				}
			}
		});
		add(tf_PW);
		
		JLabel label_PWC = new JLabel("PW Check");
		label_PWC.setBounds(135, 490, 80, 30);
		label_PWC.setFont(font);
		label_PWC.setForeground(Color.WHITE);
		add(label_PWC);
		
		JPasswordField tf_PWC = new JPasswordField();
		tf_PWC.setBounds(135, 520, 260, 20);
		add(tf_PWC);
		
		JButton bt_menulogin = new JButton("CHANGE PW");
		bt_menulogin.setBounds(135, 560, 260, 30);
		bt_menulogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_ID.getText().equals("") && tf_PW.getText().equals("")) {
					JOptionPane.showMessageDialog(Main.f, "ID, PW 필수 입력!");
				}
				else if(tf_ID.getText().equals("")) {
					JOptionPane.showMessageDialog(Main.f, "ID 필수 입력!");
				}
				else if(tf_PW.getText().equals("")) {
					JOptionPane.showMessageDialog(Main.f, "PW 필수 입력!");
				}
				else if(!tf_PW.getText().equals(tf_PWC.getText())) {
					JOptionPane.showMessageDialog(Main.f, "Wrong Password!!");
				}
				else {
					System.out.println("ID : " + tf_ID.getText() + "\n" + "PW : " + tf_PW.getText());

					int result = dao.update(tf_ID.getText(), tf_PW.getText());
					
					if(result > 0) {
						JOptionPane.showMessageDialog(Main.f, "PW changed SuccessFully!!");
					}else {
						JOptionPane.showMessageDialog(Main.f, "Error");
						tf_ID.setText("");
						tf_PW.setText("");
						tf_PWC.setText("");
					}
				} 
			}
		});
		
		add(bt_menulogin);
		
		JButton bt_main = new JButton("Back To Login");
		bt_main.setBounds(135, 600, 260, 30);
		bt_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.movePanel(1);
				
			}
		});
		add(bt_main);
		
	}
}
