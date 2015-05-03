package de.timc.mcorelib.pvp.kits;

import java.util.ArrayList;

public class KitManager {
	private static KitManager instance;
	private ArrayList<Kit> kits;

	public KitManager() throws KitManagerCreateException {
		if (instance == null) {
			instance = this;
		} else {
			throw new KitManagerCreateException();
		}
		kits = new ArrayList<Kit>();
	}
	
	public void removeKit(String name) throws KitNotFoundException{
		this.kits.remove(getKit(name));
	}
	
	public Kit createKit(String name){
		Kit kit;
		try {
			kit = getKit(name);
		} catch (KitNotFoundException e) {
			kit = new Kit(name);
			this.kits.add(kit);
		}
		
		return kit;
	}
	public Kit getKit(String name) throws KitNotFoundException{
		for(Kit k:kits){
			if(k.getName().equals(name)){
				return k;
			}
		}
		throw new KitNotFoundException();
		
	}

	public ArrayList<Kit> getAllKits() {
		return kits;
	}

}
