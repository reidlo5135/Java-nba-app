package com.app.nba.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MenuPanel extends JPanel{
	
	public MenuPanel() {
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
		
		JButton btn_team = new JButton("TEAM");
		btn_team.setBounds(140, 380, 255, 50);
		btn_team.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.movePanel(4);
			}
		});
		add(btn_team);
		
		JButton btn_player = new JButton("PLAYERS");
		btn_player.setBounds(140, 450, 255, 50);
		btn_player.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.movePanel(5);
			}
		});
		add(btn_player);
		
		JButton btn_search = new JButton("SEARCH");
		btn_search.setBounds(140, 520, 255, 50);
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.movePanel(6);
			}
		});
		add(btn_search);
	}
}
