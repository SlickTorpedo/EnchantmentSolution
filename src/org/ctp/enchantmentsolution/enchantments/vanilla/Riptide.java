package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.nms.ItemType;

public class Riptide extends CustomEnchantment{
	
	public Riptide() {
		setDefaultDisplayName("Riptide");
		setDefaultFiftyConstant(7);
		setDefaultThirtyConstant(7);
		setDefaultFiftyModifier(11);
		setDefaultThirtyModifier(10);
		setDefaultFiftyMaxConstant(30);
		setDefaultThirtyMaxConstant(17);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(5);
		setDefaultThirtyMaxLevel(3);
		setDefaultWeight(Weight.RARE);
		setDefaultDescription("Returns a thrown trident after it hits something.");
	}

	@Override
	public String getName() {
		return "riptide";
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.RIPTIDE;
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.TRIDENT);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.TRIDENT);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList(Enchantment.CHANNELING, Enchantment.LOYALTY);
	}
}
