package com.tenjava.entries.oaschi.t3.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.metadata.Metadatable;

public class PlayerStareEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	
	/**
	 * Self-explanatory
	 */
	private Player player;
	/**
	 * The object the player stares at.
	 */
	private Metadatable obj;
	
	public PlayerStareEvent(Player player, Metadatable obj){
		
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Metadatable getObj() {
		return obj;
	}

	public void setObj(Metadatable obj) {
		this.obj = obj;
	}

}
