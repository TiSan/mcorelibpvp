package de.timc.mcorelib.pvp.events;

import de.timc.mcorelib.pvp.plugin.MCoreLibPVPPlugin;

public class MCorePVPListener {

	private MCoreLibPVPPlugin plugin;

	
	public MCorePVPListener(MCoreLibPVPPlugin plugin){
		this.plugin = plugin;
		
	}
	public MCoreLibPVPPlugin getPlugin() {
		return plugin;
	}
	
	
	
}
