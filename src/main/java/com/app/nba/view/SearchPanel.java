package com.app.nba.view;

import com.app.nba.model.team.TeamDAO;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Locale;
import java.util.Map;


public class SearchPanel extends JPanel{
	static TeamDAO dao = new TeamDAO();
	
	public SearchPanel() {
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
		logo.setBounds(120, 100, 300, 250);
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.movePanel(2);
			}
		});
		add(logo);
		
		JTextField tf_Search = new JTextField();
		tf_Search.setBounds(100, 400, 345, 30);
		add(tf_Search);
		
		JButton search = new JButton("Search");
		search.setBounds(220, 500, 120, 50);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String keyword = tf_Search.getText();
				System.out.println("SearchPanel sp : " + keyword);
				
				JPanel p = new JPanel();
				p.setSize(1024, 824);
				p.setBackground(Color.BLACK);
				p.setLayout(null);
				
				URL pFile = TeamPanel.class.getResource("/img/" + keyword + ".png");
				if(pFile == null) {
					JOptionPane.showMessageDialog(Main.f, "검색된 결과가 존재하지 않습니다.");
				}
				System.out.println("stp : " + pFile);
				
				ImageIcon teamIcon = new ImageIcon(pFile);
				Image teamImage = teamIcon.getImage();
				Image nImage = teamImage.getScaledInstance(150, 150, 0);
				ImageIcon nIcon = new ImageIcon(nImage);
				
				JLabel teamLogo = new JLabel(nIcon);
				teamLogo.setBounds(360, 30, 250, 250);
				p.add(teamLogo);
				
				int x4 = 460;

				Map<String, JSONObject> teamInformationMap = dao.getTeamInformationByName();
				System.out.println("SearchPanel teamInfoMap : " + teamInformationMap);
				if(teamInformationMap.get(keyword) == null) {
					JOptionPane.showMessageDialog(Main.f, "검색된 결과가 존재하지 않습니다.");
				}
				System.out.println("SearchPanel teamButton Action Performed SearchResult : " + teamInformationMap.get(keyword));

				String team_name = teamInformationMap.get(keyword).get("full_name").toString();
				String city = teamInformationMap.get(keyword).get("city").toString();
				String conference = teamInformationMap.get(keyword).get("conference").toString();
				String division = teamInformationMap.get(keyword).get("division").toString();

				JLabel lb_menu_team = new JLabel("TEAM : ");
				lb_menu_team.setBounds(400, 200, 200, 200);
				lb_menu_team.setForeground(Color.WHITE);

				JLabel lb_team = new JLabel(team_name);
				lb_team.setBounds(x4, 200, 200, 200);
				lb_team.setForeground(Color.WHITE);

				JLabel lb_city_team = new JLabel("CITY : ");
				lb_city_team.setBounds(400, 250, 200, 200);
				lb_city_team.setForeground(Color.WHITE);

				JLabel lb_city = new JLabel(city);
				lb_city.setBounds(x4, 250, 200, 200);
				lb_city.setForeground(Color.WHITE);

				JLabel lb_conf_team = new JLabel("CONFERENCE : ");
				lb_conf_team.setBounds(400, 300, 200, 200);
				lb_conf_team.setForeground(Color.WHITE);

				JLabel lb_conf = new JLabel(conference.toUpperCase(Locale.ROOT));
				lb_conf.setBounds(x4+30, 300, 200, 200);
				lb_conf.setForeground(Color.WHITE);

				JLabel lb_division_team = new JLabel("DIVISION : ");
				lb_division_team.setBounds(400, 350, 200, 200);
				lb_division_team.setForeground(Color.WHITE);

				JLabel lb_division = new JLabel(division.toUpperCase(Locale.ROOT));
				lb_division.setBounds(x4+10, 350, 200, 200);
				lb_division.setForeground(Color.WHITE);

				p.add(lb_menu_team);
				p.add(lb_team);
				p.add(lb_city_team);
				p.add(lb_city);
				p.add(lb_conf_team);
				p.add(lb_conf);
				p.add(lb_division_team);
				p.add(lb_division);
				p.setVisible(true);
				
				repaint();
				revalidate();
				
				setVisible(false);
				
				JFrame f = new JFrame();
				f.setTitle(keyword);
				f.setSize(1024, 824);
				f.setLayout(null);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JButton back = new JButton("Back To Search");
				back.setBounds(400, 500, 200, 70);
				back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						f.dispose();
						Main.movePanel(6);
					}
				});
				p.add(back);
				
				f.add(p);
			}
		});
		add(search);
	}
}
