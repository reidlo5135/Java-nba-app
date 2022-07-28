package com.app.nba.view;

import com.app.nba.model.user.MemberDAO;
import com.app.nba.model.user.MemberVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JoinPanel extends JPanel{
	static MemberDAO dao = new MemberDAO();
	
	public JoinPanel() {
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
		label_ID.setBounds(135, 360, 60, 30);
		Font font = new Font("휴먼모음T", Font.BOLD, 15);
		label_ID.setFont(font);
		label_ID.setForeground(Color.WHITE);
		add(label_ID);
				
		JTextField tf_ID = new JTextField();
		tf_ID.setBounds(135, 385, 260, 20);
		add(tf_ID);
		
		JLabel label_N = new JLabel("Name");
		label_N.setBounds(135, 415, 60, 30);
		label_N.setFont(font);
		label_N.setForeground(Color.WHITE);
		add(label_N);
		
		JTextField tf_N = new JTextField();
		tf_N.setBounds(135, 445, 260, 20);
		add(tf_N);
		
		JLabel label_PW = new JLabel("PW");
		label_PW.setBounds(135, 475, 60, 30);
		label_PW.setFont(font);
		label_PW.setForeground(Color.WHITE);
		add(label_PW);
		
		JPasswordField tf_PW = new JPasswordField();
		tf_PW.setBounds(135, 505, 260, 20);
		add(tf_PW);
		
		JLabel label_PWC = new JLabel("PW Check");
		label_PWC.setBounds(135, 535, 80, 30);
		label_PWC.setFont(font);
		label_PWC.setForeground(Color.WHITE);
		add(label_PWC);
		
		JPasswordField tf_PWC = new JPasswordField();
		tf_PWC.setBounds(135, 565, 260, 20);
		add(tf_PWC);
		
		JButton bt_join = new JButton("Join Us");
		bt_join.setBounds(135, 605, 260, 30);
		bt_join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_ID.getText().equals("")) {
					JOptionPane.showMessageDialog(Main.f, "Your ID is empty");
				}
				else if(tf_N.getText().equals("")) {
					JOptionPane.showMessageDialog(Main.f, "Your Name is empty");
				}
				else if(tf_PW.getText().equals("")) {
					JOptionPane.showMessageDialog(Main.f, "Your PW is empty");
				}
				else if(!tf_PW.getText().equals(tf_PWC.getText())) {
					JOptionPane.showMessageDialog(Main.f, "Wrong Password!!");
				}
				else {
					System.out.println("ID : " + tf_ID.getText() + "\n" + "PW : " + tf_PW.getText());
					int result = dao.isIDExists(tf_ID.getText());
					
					if(result > 0) {
						JOptionPane.showMessageDialog(Main.f, "This ID Exists Already! \n Use Other ID");
					}else {
						MemberVO vo = new MemberVO();
						vo.setId(tf_ID.getText());
						vo.setPwd(tf_PW.getText());
						vo.setName(tf_N.getText());
						dao.register(vo);
						
						JOptionPane.showMessageDialog(Main.f, "Welcome " + tf_ID.getText() + "!");
						Main.movePanel(1);
					}
				}
				
			}
		});
		add(bt_join);
		
		JButton bt_cancel = new JButton("Cancel");
		bt_cancel.setBounds(135, 645, 260, 30);
		bt_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_ID.setText("");
				tf_PW.setText("");
				
			}
		});
		add(bt_cancel);
		
		
		JButton bt_main = new JButton("Back To Login");
		bt_main.setBounds(135, 685, 260, 30);
		bt_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.movePanel(1);
				
			}
		});
		add(bt_main);
	}
}
