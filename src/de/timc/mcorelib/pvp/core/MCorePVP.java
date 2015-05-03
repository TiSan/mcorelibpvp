package de.timc.mcorelib.pvp.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.timc.mcorelib.pvp.kits.KitManager;
import de.timc.mcorelib.pvp.kits.KitManagerCreateException;
import de.timc.mcorelib.pvp.plugin.MCoreLibPVPPlugin;
import de.timc.mcorelib.pvp.teams.TeamManager;
import de.timc.mcorelib.pvp.update.MCorePVPUpdate;
import de.timc.mcorelib.pvp.update.MCorePVPUpdateManager;

public class MCorePVP {
	private static MCorePVP instance;
	private MCoreLibPVPPlugin plugin;
	private KitManager kitManager;
	public static String version = "0.1.2";
	public static String header = "[MCore PVP-Pack] ";
	public static MCorePVP get() {
		return (instance == null ? (instance = new MCorePVP()) : instance);
	}

	private MCorePVP() {
		try {
			this.kitManager = new KitManager();
		} catch (KitManagerCreateException e) {
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				MCorePVPUpdate upd = MCorePVPUpdateManager.checkUpdate();
				if (upd != null) {
					System.out.println("[MCoreLibPVP] A new version of MCoreLib PVPPack is now available! Check it out soon!");
					System.out.println("[MCoreLibPVP] Your version: '" + version + "', new version: '" + upd.getVersion() + " >" + upd.getVersionState() + "<'!");
					System.out.println("[MCoreLibPVP] Download-Link: " + upd.getPath());
					System.out.println("[MCoreLibPVP] Things changed in new version (Changelog):");
					for (String tmp : upd.getChangelog()) {
						System.out.println("[MCoreLibPVP] [Changelog] " + tmp);
					}
					System.out.println("[MCoreLibPVP] You don't need to update, but it is highly recommended.");
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (p.isOp()) {
							p.sendMessage(header + "§eFor the MCore library (PVP Pack Extention) is a new version available. More information in your console.");
						}
					}
				} else {
					System.out.println("[MCoreLibPVP] MCoreLib PVP Pack version " + version + " activated and running!");
				}
			}

		}).start();
	}

	public void setPluginInstance(MCoreLibPVPPlugin plugin) {
		this.plugin = plugin;
	}

	public KitManager getKitManager() {
		return kitManager;
	}

	public MCoreLibPVPPlugin getPlugin() {
		return plugin;
	}

	public TeamManager getTeamManager() {
		return TeamManager.get();
	}

}
