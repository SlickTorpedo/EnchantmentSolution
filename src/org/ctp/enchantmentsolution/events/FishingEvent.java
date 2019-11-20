package org.ctp.enchantmentsolution.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public abstract class FishingEvent extends PlayerEvent implements Cancellable {

	private static final HandlerList handlers = new HandlerList();

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	private boolean cancelled = false;
	private Material fish;

	public FishingEvent(Player who, Material fish) {
		super(who);
		this.fish = fish;
	}

	public Material getFish() {
		return fish;
	}

	public void setFish(Material fish) {
		this.fish = fish;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}