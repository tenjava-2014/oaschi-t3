package com.tenjava.entries.oaschi.t3.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.tenjava.entries.oaschi.t3.RandomShitUtils;
import com.tenjava.entries.oaschi.t3.events.PlayerStareEvent;

public class PlayerStareListener implements Listener{
	
	@EventHandler
	public void doRandomStuff(PlayerStareEvent event){
		RandomShitUtils.flash(event.getPlayer(), event.getTarget());
	}
}
