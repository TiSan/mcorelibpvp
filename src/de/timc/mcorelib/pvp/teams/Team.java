package de.timc.mcorelib.pvp.teams;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import de.timc.mcorelib.plugin.MCorePlayer;

public class Team {
	private String name;
	private ChatColor color;
	private ArrayList<MCorePlayer> players;

	public Team(String name, ChatColor color) {
		this.name = name;
		this.color = color;
		this.players = new ArrayList<MCorePlayer>();
	}

	public String getName() {
		return name;
	}

	public ChatColor getColor() {
		return color;
	}

	public ArrayList<MCorePlayer> getPlayers() {
		return players;
	}

	public boolean containsPlayer(String name) {
		for (MCorePlayer p : players) {
			if (p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsPlayer(MCorePlayer player) {
		return players.contains(player);
	}

	public void addPlayer(MCorePlayer player) {
		this.players.add(player);
	}

	public void remPlayer(MCorePlayer player) {
		if (this.players.contains(player)) {
			this.players.remove(player);
		}
	}
}
