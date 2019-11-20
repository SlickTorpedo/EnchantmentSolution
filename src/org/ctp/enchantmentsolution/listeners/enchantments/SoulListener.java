package org.ctp.enchantmentsolution.listeners.enchantments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.advancements.ESAdvancement;
import org.ctp.enchantmentsolution.enchantments.RegisterEnchantments;
import org.ctp.enchantmentsolution.events.soul.SoulReaperEvent;
import org.ctp.enchantmentsolution.events.soul.SoulboundEvent;
import org.ctp.enchantmentsolution.listeners.Enchantmentable;
import org.ctp.enchantmentsolution.utils.AdvancementUtils;
import org.ctp.enchantmentsolution.utils.items.ItemUtils;

@SuppressWarnings("unused")
public class SoulListener extends Enchantmentable {

	@EventHandler
	public void onDeathListener(PlayerDeathEvent event) {
		runMethod(this, "soulbound", event, PlayerDeathEvent.class);
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		runMethod(this, "soulbound", event, PlayerRespawnEvent.class);
	}

	private void soulbound(PlayerDeathEvent event) {
		if (!canRun(RegisterEnchantments.SOULBOUND, event)) {
			return;
		}
		List<ItemStack> items = event.getDrops();
		List<ItemStack> soulbound = new ArrayList<ItemStack>();
		Player player = event.getEntity();
		if (event.getKeepInventory()) {
			return;
		}

		for(ItemStack item: items) {
			if (ItemUtils.hasEnchantment(item, RegisterEnchantments.SOULBOUND)) {
				soulbound.add(item);
			}
		}
		if (soulbound.size() == 0) {
			return;
		}

		SoulboundEvent soulboundEvent = new SoulboundEvent(player, soulbound);
		Bukkit.getPluginManager().callEvent(soulboundEvent);

		if (!soulboundEvent.isCancelled()) {
			ItemStack killItem = null;
			if (player.getKiller() != null) {
				if (player.getKiller() instanceof Player) {
					killItem = player.getKiller().getInventory().getItemInMainHand();
				}
			}

			List<ItemStack> savedItems = new ArrayList<ItemStack>();
			savedItems.addAll(soulboundEvent.getSavedItems());

			if (killItem != null && RegisterEnchantments.isEnabled(RegisterEnchantments.SOUL_REAPER)
			&& ItemUtils.hasEnchantment(killItem, RegisterEnchantments.SOUL_REAPER)) {
				List<ItemStack> soulReaper = new ArrayList<ItemStack>();
				int level = ItemUtils.getLevel(killItem, RegisterEnchantments.SOUL_REAPER);
				if (level > savedItems.size()) {
					soulReaper.addAll(savedItems);
				} else {
					while (soulReaper.size() < level) {
						int random = (int) (Math.random() * savedItems.size());
						soulReaper.add(savedItems.remove(random));
					}
					savedItems = new ArrayList<ItemStack>();
					savedItems.addAll(soulboundEvent.getSavedItems());
				}

				if (soulReaper.size() > 0) {
					SoulReaperEvent soulReaperEvent = new SoulReaperEvent(player, soulReaper);
					Bukkit.getPluginManager().callEvent(soulReaperEvent);

					if (!soulReaperEvent.isCancelled()) {
						if (soulReaperEvent.getReapedItems().size() > 0) {
							AdvancementUtils.awardCriteria(player.getKiller(), ESAdvancement.FEAR_THE_REAPER, "reaper");
							player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, player.getLocation(), 50, 0.2, 2,
							0.2);
							player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.6f, 0.6f);
							for(ItemStack item: soulReaperEvent.getReapedItems()) {
								if (ItemUtils.hasEnchantment(item, RegisterEnchantments.SOUL_REAPER)) {
									AdvancementUtils.awardCriteria(player.getKiller(), ESAdvancement.REAPED_THE_REAPER,
									"reaper");
								}
							}
						}
						for(ItemStack i: soulReaperEvent.getReapedItems()) {
							savedItems.remove(i);
						}
					}
				}
			}

			if (savedItems.size() > 0) {
				for(ItemStack i: savedItems) {
					event.getDrops().remove(i);
				}
			}

			EnchantmentSolution.setSoulItems(player, savedItems);
		}
	}

	private void soulbound(PlayerRespawnEvent event) {
		if (!canRun(RegisterEnchantments.SOULBOUND, event)) {
			return;
		}
		Player player = event.getPlayer();
		HashMap<Material, Boolean> diamonds = new HashMap<Material, Boolean>();
		diamonds.put(Material.DIAMOND_AXE, false);
		diamonds.put(Material.DIAMOND_BOOTS, false);
		diamonds.put(Material.DIAMOND_CHESTPLATE, false);
		diamonds.put(Material.DIAMOND_HELMET, false);
		diamonds.put(Material.DIAMOND_HOE, false);
		diamonds.put(Material.DIAMOND_LEGGINGS, false);
		diamonds.put(Material.DIAMOND_PICKAXE, false);
		diamonds.put(Material.DIAMOND_SHOVEL, false);
		diamonds.put(Material.DIAMOND_SWORD, false);
		List<ItemStack> items = EnchantmentSolution.getSoulItems(player);
		if (items != null) {
			for(ItemStack item: items) {
				AdvancementUtils.awardCriteria(player, ESAdvancement.KEPT_ON_HAND, "soulbound");
				if (diamonds.containsKey(item.getType())) {
					diamonds.put(item.getType(), true);
				}
				player.getInventory().addItem(item);
			}
			if (!diamonds.containsValue(false)) {
				AdvancementUtils.awardCriteria(player, ESAdvancement.READY_AFTER_DEATH, "soulbound");
			}
		}
		EnchantmentSolution.removeSoulItems(player);
	}
}