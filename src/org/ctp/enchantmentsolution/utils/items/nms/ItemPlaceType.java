package org.ctp.enchantmentsolution.utils.items.nms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;

public class ItemPlaceType {
	public static List<Material> getPlaceTypes(){
		List<Material> itemTypes = new ArrayList<Material>();
		
		for(String s : getPlaceStrings()) {
			try {
				itemTypes.add(Material.valueOf(s));
			} catch (Exception ex) {
				
			}
		}
		
		return itemTypes;
	}
	
	private static List<String> getPlaceStrings(){
		List<String> itemTypes = new ArrayList<String>();
		itemTypes.addAll(Arrays.asList("IRON_BLOCK", "LAPIS_BLOCK", "IRON_ORE", "LAPIS_ORE", "DIAMOND_BLOCK", "EMERALD_BLOCK", "GOLD_BLOCK", "DIAMOND_ORE", 
				"EMERALD_ORE", "GOLD_ORE", "REDSTONE_ORE", "OBSIDIAN", "JACK_O_LANTERN", "PUMPKIN", "MELON", "BOOKSHELF", "ACACIA_LOG", "ACACIA_PLANKS", "BIRCH_LOG", 
				"BIRCH_PLANKS", "DARK_OAK_LOG", "DARK_OAK_PLANKS", "JUNGLE_LOG", "JUNGLE_PLANKS", "OAK_LOG", "OAK_PLANKS", "SPRUCE_LOG", "SPRUCE_PLANKS", 
				"ACACIA_WOOD", "BIRCH_WOOD", "DARK_OAK_WOOD", "JUNGLE_WOOD", "OAK_WOOD", "SPRUCE_WOOD", "STRIPPED_ACACIA_LOG", "STRIPPED_BIRCH_LOG", 
				"STRIPPED_DARK_OAK_LOG", "STRIPPED_JUNGLE_LOG", "STRIPPED_OAK_LOG", "STRIPPED_SPRUCE_LOG,STRIPPED_ACACIA_WOOD", "STRIPPED_BIRCH_WOOD", 
				"STRIPPED_DARK_OAK_WOOD", "STRIPPED_JUNGLE_WOOD", "STRIPPED_OAK_WOOD", "STRIPPED_SPRUCE_WOOD", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "ICE", 
				"PACKED_ICE", "FROSTED_ICE", "BLUE_ICE", "REDSTONE_BLOCK", "ANDESITE", "COAL_BLOCK", "QUARTZ_BLOCK", "BRICKS", "COAL_ORE", "COBBLESTONE", 
				"BLACK_CONCRETE", "BLUE_CONCRETE", "BROWN_CONCRETE", "CYAN_CONCRETE", "GRAY_CONCRETE", "GREEN_CONCRETE", "LIGHT_BLUE_CONCRETE", "LIGHT_GRAY_CONCRETE", 
				"LIME_CONCRETE", "MAGENTA_CONCRETE", "ORANGE_CONCRETE", "PINK_CONCRETE", "PURPLE_CONCRETE", "RED_CONCRETE", "WHITE_CONCRETE", "YELLOW_CONCRETE", 
				"DARK_PRISMARINE", "DIORITE", "END_STONE", "END_STONE_BRICKS", "TERRACOTTA", "BLACK_GLAZED_TERRACOTTA", "BLUE_GLAZED_TERRACOTTA", 
				"BROWN_GLAZED_TERRACOTTA", "CYAN_GLAZED_TERRACOTTA", "GRAY_GLAZED_TERRACOTTA", "GREEN_GLAZED_TERRACOTTA", "LIGHT_BLUE_GLAZED_TERRACOTTA", 
				"LIGHT_GRAY_GLAZED_TERRACOTTA", "LIME_GLAZED_TERRACOTTA", "MAGENTA_GLAZED_TERRACOTTA", "ORANGE_GLAZED_TERRACOTTA", "PINK_GLAZED_TERRACOTTA", 
				"PURPLE_GLAZED_TERRACOTTA", "RED_GLAZED_TERRACOTTA", "WHITE_GLAZED_TERRACOTTA", "YELLOW_GLAZED_TERRACOTTA", "GRANITE", "MOSSY_COBBLESTONE", 
				"MOSSY_COBBLESTONE_WALL", "NETHER_BRICK", "NETHER_BRICK_FENCE", "NETHER_QUARTZ_ORE", "NETHERRACK", "POLISHED_ANDESITE", "POLISHED_DIORITE", 
				"POLISHED_GRANITE", "PRISMARINE", "PRISMARINE_BRICKS", "RED_SANDSTONE", "SANDSTONE", "BLACK_TERRACOTTA", "BLUE_TERRACOTTA", "BROWN_TERRACOTTA", 
				"CYAN_TERRACOTTA", "GRAY_TERRACOTTA", "GREEN_TERRACOTTA", "LIGHT_BLUE_TERRACOTTA", "LIGHT_GRAY_TERRACOTTA", "LIME_TERRACOTTA", "MAGENTA_TERRACOTTA", 
				"ORANGE_TERRACOTTA", "PINK_TERRACOTTA", "PURPLE_TERRACOTTA", "RED_TERRACOTTA", "WHITE_TERRACOTTA", "YELLOW_TERRACOTTA", "STONE", "STONE_BRICKS", 
				"MOSSY_STONE_BRICKS", "CRACKED_STONE_BRICKS", "CHISELED_STONE_BRICKS", "INFESTED_CHISELED_STONE_BRICKS", "INFESTED_COBBLESTONE", 
				"INFESTED_CRACKED_STONE_BRICKS", "INFESTED_MOSSY_STONE_BRICKS", "INFESTED_STONE", "INFESTED_STONE_BRICKS", "BRAIN_CORAL_BLOCK", "BUBBLE_CORAL_BLOCK", 
				"FIRE_CORAL_BLOCK", "HORN_CORAL_BLOCK", "TUBE_CORAL_BLOCK", "SMOOTH_STONE", "SMOOTH_QUARTZ", "MAGMA_BLOCK", "SMOOTH_RED_SANDSTONE", 
				"SMOOTH_SANDSTONE", "SNOW_BLOCK", "CLAY", "COARSE_DIRT", "DIRT", "GRASS_BLOCK", "GRAVEL", "MYCELIUM", "PODZOL", "RED_SAND", "SAND", "SOUL_SAND", 
				"BLACK_CONCRETE_POWDER", "BLUE_CONCRETE_POWDER", "BROWN_CONCRETE_POWDER", "CYAN_CONCRETE_POWDER", "GRAY_CONCRETE_POWDER", "GREEN_CONCRETE_POWDER", 
				"LIGHT_BLUE_CONCRETE_POWDER", "LIGHT_GRAY_CONCRETE_POWDER", "LIME_CONCRETE_POWDER", "MAGENTA_CONCRETE_POWDER", "ORANGE_CONCRETE_POWDER", 
				"PINK_CONCRETE_POWDER", "PURPLE_CONCRETE_POWDER", "RED_CONCRETE_POWDER", "WHITE_CONCRETE_POWDER", "YELLOW_CONCRETE_POWDER"));
		return itemTypes;
	}
}
