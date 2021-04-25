package org.ctp.enchantmentsolution.interfaces;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.helper.EnchantmentLevel;
import org.ctp.enchantmentsolution.utils.items.EnchantmentUtils;

public interface WalkerInterface extends ESInterface {

	public Material getReplacedMaterial();

	public Material getReplaceMaterial();

	public String getMetadata();

	public boolean replaceAir();

	public boolean canRun(Player player, Location from, Location to);

	public Location getProperLocation(Player player, Location from, Location to);

	public static boolean hasWalkerInterface(ItemStack item) {
		for(EnchantmentLevel enchant: EnchantmentUtils.getEnchantmentLevels(item))
			if (InterfaceRegistry.getWalkerInterfaces().containsKey(enchant.getEnchant().getRelativeEnchantment())) return true;
		return false;
	}

	public static WalkerInterface getFromMetadata(String s) {
		Iterator<Entry<Enchantment, WalkerInterface>> iter = InterfaceRegistry.getWalkerInterfaces().entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Enchantment, WalkerInterface> entry = iter.next();
			WalkerInterface inter = entry.getValue();
			if (inter.getMetadata().equals(s)) return inter;
		}
		return null;
	}

	public static WalkerInterface getFromMaterial(Material m) {
		Iterator<Entry<Enchantment, WalkerInterface>> iter = InterfaceRegistry.getWalkerInterfaces().entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Enchantment, WalkerInterface> entry = iter.next();
			WalkerInterface inter = entry.getValue();
			if (inter.getReplaceMaterial() == m) return inter;
		}
		return null;
	}

	public static HashMap<Enchantment, WalkerInterface> getWalkerInterfaces(ItemStack item) {
		HashMap<Enchantment, WalkerInterface> inters = new HashMap<Enchantment, WalkerInterface>();

		Iterator<Entry<Enchantment, WalkerInterface>> iter = InterfaceRegistry.getWalkerInterfaces().entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Enchantment, WalkerInterface> entry = iter.next();
			WalkerInterface inter = entry.getValue();
			if (EnchantmentUtils.hasEnchantment(item, inter.getEnchantment())) inters.put(inter.getEnchantment(), inter);
		}
		return inters;
	}
}
