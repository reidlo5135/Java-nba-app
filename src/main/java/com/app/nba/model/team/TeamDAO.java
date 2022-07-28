package com.app.nba.model.team;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamDAO {
	static ApiUtils apiUtils = new ApiUtils();

	public Map<String, List<String>> getAllTeamNames() {
		Map<String, List<String>> map = new HashMap<>();
		try {
			 map = apiUtils.getAllTeamNames();
			 System.out.println("TeamDAO getAllTeams map : " + map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, JSONObject> getTeamInformationByName() {
		Map<String, JSONObject> map = new HashMap<>();
		try {
			map = apiUtils.getTeamInformationByName();
			System.out.println("TeamDAO getTeamInformationByName map : " + map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, List<String>> getAllPlayers() {
		Map<String, List<String>> map = new HashMap<>();
		try {
			map = apiUtils.getAllPlayers();
			System.out.println("TeamDAO getAllPlayers map : " + map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
