package com.app.nba.view;

import javax.swing.*;

public class Main{
	static JFrame f = new JFrame();
	private static LoginPanel lp = new LoginPanel();
	private static JoinPanel jp = new JoinPanel();
	private static MenuPanel mp = new MenuPanel();
	private static TeamPanel tp = new TeamPanel();
	private static SearchPanel sp = new SearchPanel();
	private static ModifyPanel fp = new ModifyPanel();
	
	public static void movePanel(int index) {
		lp.setVisible(false);
		jp.setVisible(false);
		mp.setVisible(false);
		tp.setVisible(false);
		sp.setVisible(false);
		fp.setVisible(false);
		
		switch(index) {
		case 1 : f.setTitle("LOGIN");
			lp.setVisible(true);
		break;
		case 2 : f.setTitle("WELCOME");
			f.setSize(550, 800);
			mp.setVisible(true);
		break;
		case 3 : f.setTitle("JOIN");
			jp.setVisible(true);
		break;
		case 4 : f.setTitle("TEAM");
			f.setSize(1024, 824);
			tp.setVisible(true);
		break;
		case 5 : f.setTitle("PLAYERS");
		
		break;
		case 6 : f.setTitle("SEARCH");
			sp.setVisible(true);
		break;
		case 7 : f.setTitle("MODIFY PAGE");
			fp.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		f.add(lp);
		f.add(jp);
		f.add(mp);
		f.add(tp);
		f.add(sp);
		f.add(fp);
		
		f.setSize(550, 800);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		movePanel(1);
	}
}
