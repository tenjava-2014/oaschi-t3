package com.tenjava.entries.oaschi.t3;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;

public class StalkerTask implements Runnable{
	private Quantumizer plugin = Quantumizer.plugin;

	@Override
	public void run() {
		if(!plugin.isActive()){
			Bukkit.getServer().getScheduler().cancelTask(plugin.getTaskId());
			return;
		}
		
		for(Player player : Bukkit.getOnlinePlayers()){
			listen(player);
		}
	}
	
	private void listen(Player player){
		int maxDistance = plugin.getMaxDistance();
		BlockIterator iter = new BlockIterator(player, maxDistance);
		Block block;
		while(iter.hasNext()){
			block = iter.next();
			if(block.getType() != Material.AIR){
				
			}
		}
	}

}
