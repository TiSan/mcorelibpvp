package de.timc.mcorelib.pvp.plugin;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.timc.mcorelib.pvp.core.MCorePVP;
import de.timc.mcorelib.pvp.events.MCorePVPListener;
import de.timc.mcorelib.pvp.metrics.Metrics;

public class MCoreLibPVPPlugin extends JavaPlugin implements Listener {
	private MCorePVPListener listener;

	@Override
	public void onEnable() {
		MCorePVP.get().setPluginInstance(this);
		this.listener = new MCorePVPListener(this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Metrics me;
		try {
			me = new Metrics(this);
			me.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MCorePVPListener getListener() {
		return listener;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
	}

	@EventHandler
	public void onDiconnect(PlayerQuitEvent e) {
	}
}
