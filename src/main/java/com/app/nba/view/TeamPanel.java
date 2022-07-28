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
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class TeamPanel extends JPanel {
	static TeamDAO dao = new TeamDAO();

	public TeamPanel() {
		setView();
		setSize(1024, 824);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
	}
	
	void setView() {
		URL imgURL = TeamPanel.class.getResource("/img/logo.png");
		System.out.println("logo : " + imgURL);
		ImageIcon imgIcon = new ImageIcon(imgURL);
		JLabel logo = new JLabel(imgIcon);
		logo.setSize(250, 250);
		logo.setLayout(null);
		logo.setBounds(360, 30, 250, 250);
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.movePanel(2);
			}
		});
		add(logo);

		Map<String, List<String>> teamMap = dao.getAllTeamNames();
		System.out.println("TeamPanel map : " + teamMap);

		List<String> team_name = teamMap.get("team_name");
		
		int x = 113;
		int x2 = 113;
		int x3 = 113;
		int x4 = 213;
		
		for(int i=0;i<team_name.size();i++) {
			URL team = TeamPanel.class.getResource("/img/" + team_name.get(i) + ".png");
			String file = team_name.get(i);

			System.out.println("team_name.get(i) : " + team_name.get(i));
			System.out.println("team : " + team);
			System.out.println("file : " + file);
			
			ImageIcon teamIcon = new ImageIcon(team);
			Image teamImage = teamIcon.getImage();
			Image nImage = teamImage.getScaledInstance(85, 85, 0);
			ImageIcon nIcon = new ImageIcon(nImage);
			
			JButton teamLogo = new JButton(nIcon);
			
			if(i<8) {
				teamLogo.setBounds(x, 320, 85, 85);
			} else if(i>=8 && i<16) {
				teamLogo.setBounds(x2, 427, 85, 85);
				x2 = x2 + 100;
			} else if(i>=16 && i<24) {
				teamLogo.setBounds(x3, 534, 85, 85);
				x3 = x3 + 100;
			} else if(i>=24 && i<31) {
				teamLogo.setBounds(x4, 641, 85, 85);
				x4 = x4 + 100;
			}
			teamLogo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("teamLogo team : " + team);
					System.out.println("teamLogo file : " + file);
					
					JPanel p = new JPanel();
					p.setSize(1024, 768);
					p.setBackground(Color.BLACK);
					p.setLayout(null);
					
					URL pFile = TeamPanel.class.getResource("/img/" + file + ".png");
					System.out.println("teamLogo stp : " + pFile);
					
					ImageIcon teamIcon = new ImageIcon(pFile);
					Image teamImage = teamIcon.getImage();
					Image nImage = teamImage.getScaledInstance(150, 150, 0);
					ImageIcon nIcon = new ImageIcon(nImage);
					
					JLabel teamLogo = new JLabel(nIcon);
					teamLogo.setBounds(360, 30, 250, 250);
					p.add(teamLogo);
					
					int x4 = 460;

					Map<String, JSONObject> teamInformationMap = dao.getTeamInformationByName();
					System.out.println("TeamPanel teamInfoMap : " + teamInformationMap);
					System.out.println("TeamPanel teamButton Action Performed : " + teamInformationMap.get(file));

					String team_name = teamInformationMap.get(file).get("full_name").toString();
					String city = teamInformationMap.get(file).get("city").toString();
					String conference = teamInformationMap.get(file).get("conference").toString();
					String division = teamInformationMap.get(file).get("division").toString();

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
					p.setSize(1024, 824);
					
					repaint();
					revalidate();
					
					setVisible(false);
					
					JFrame f = new JFrame();
					f.setTitle(file);
					f.setSize(1024, 824);
					f.setLayout(null);
					f.setVisible(true);
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setResizable(false);
					
					JButton back = new JButton("Back To Teams");
					back.setBounds(400, 500, 200, 70);
					back.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							f.dispose();
							Main.movePanel(4);
						}
					});
					p.add(back);
					
					f.add(p);
				}
			});
			add(teamLogo);
			x = x + 100;
		}
	}
}
