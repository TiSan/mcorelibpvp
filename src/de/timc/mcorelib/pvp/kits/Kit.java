package de.timc.mcorelib.pvp.kits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit {
	private ArrayList<ItemStack> items;
	private ArrayList<ItemStack> itemsArmor;
	private String name;

	protected Kit(String name) {
		this.items = new ArrayList<ItemStack>();
		this.itemsArmor = new ArrayList<ItemStack>();
		this.name = name;
	}

	public Kit setItems(ArrayList<ItemStack> items) {
		this.items = items;
		return this;
	}

	public Kit addItem(ItemStack itemstack) {
		items.add(itemstack);
		return this;
	}
	

	public Kit addItem(ArrayList<ItemStack> itemstacks) {
		items.addAll(itemstacks);
		return this;
	}

	public Kit addItem(ItemStack... item) {
		for (ItemStack i : item) {
			items.add(i);
		}
		return this;
	}
	
	public Kit setArmorContent(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
		itemsArmor.clear();
		itemsArmor.add(helmet);
		itemsArmor.add(chestplate);
		itemsArmor.add(leggings);
		itemsArmor.add(boots);
		return this;
	}
	
	
	public Kit clear(){
		this.items.clear();
		return this;
	}
	
	public Kit removeItem(ItemStack stack) {
		if (items.contains(stack)) {
			items.remove(stack);
		}
		return this;
	}

	public String getName() {
		return name;
	}

	public Kit sendToPlayer(Player p, boolean clearInventory) {
		if (clearInventory) {
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
		}
		for (ItemStack item : getItems()) {
			p.getInventory().addItem(item);
		}
		
		if(getArmorContent().size() > 0){
			p.getInventory().setHelmet(getArmorContent().get(0));
			p.getInventory().setChestplate(getArmorContent().get(1));
			p.getInventory().setLeggings(getArmorContent().get(2));
			p.getInventory().setBoots(getArmorContent().get(3));
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ItemStack> getItems() {
		return (ArrayList<ItemStack>) items.clone();
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ItemStack> getArmorContent() {
		return (ArrayList<ItemStack>) itemsArmor.clone();
	}
	
}
