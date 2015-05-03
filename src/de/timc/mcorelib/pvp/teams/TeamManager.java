package de.timc.mcorelib.pvp.teams;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import de.timc.mcorelib.plugin.MCorePlayer;

public class TeamManager {
	private ArrayList<Team> teams;
	private static TeamManager instance;

	public static TeamManager get() {
		return (instance == null ? (instance = new TeamManager()) : instance);
	}

	public TeamManager() {
		this.teams = new ArrayList<Team>();
	}

	public Team createTeam(String name, ChatColor color) {
		Team t = new Team(name, color);
		teams.add(t);
		return t;
	}

	public Team getTeamByPlayer(MCorePlayer player) {
		for (Team t : teams) {
			if (t.containsPlayer(player)) {
				return t;
			}
		}
		return null;
	}

	public Team getTeamByPlayer(String playerName) {
		for (Team t : teams) {
			if (t.containsPlayer(playerName)) {
				return t;
			}
		}
		return null;
	}

	public void removeTeam(Team team) {
		if (teams.contains(team)) {
			teams.remove(team);
		}
	}

	public void removeTeam(String teamName) {
		for (Team t : teams) {
			if (t.getName().equals(teamName)) {
				teams.remove(t);
				return;
			}
		}
	}
}
