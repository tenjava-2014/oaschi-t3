package com.tenjava.entries.oaschi.t3;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

import com.tenjava.entries.oaschi.t3.events.PlayerStareEvent;

public class StalkerTask implements Runnable{
	private Quantumizer plugin = Quantumizer.plugin;
	
	private HashMap<Player, BlockTime> players = new HashMap<>();
	
	private long startingMillis;
	private long lastMillis;
	
	class BlockTime{
		private Block block;
		private long elapsedMillis;
		public BlockTime(Block block, long elapsedMillis){
			this.block = block;
			this.elapsedMillis = elapsedMillis;
		}
		public Block getBlock(){
			return block;
		}
		public void setBlock(Block block){
			this.block = block;
		}
		public long getElapsedMillis(){
			return elapsedMillis;
		}
		public void setElapsedMillis(long elapsedMillis) {
			this.elapsedMillis = elapsedMillis;
		}
	}
	
	public StalkerTask(){
		startingMillis = System.nanoTime() / 1_000_000;
		lastMillis = startingMillis;
	}

	@Override
	public void run() {
		if(!plugin.isActive()){
			Bukkit.getServer().getScheduler().cancelTask(plugin.getTaskId());
			return;
		}
		long curMillis = System.nanoTime() / 1_000_000;
		long elapsed = curMillis = this.lastMillis;
		this.lastMillis = curMillis;
		for(Player player : Bukkit.getOnlinePlayers()){
			listen(player, elapsed);
		}
	}
	
	private void listen(Player player, long elapsed){
		int maxDistance = plugin.getMaxDistance();
		BlockIterator iter = new BlockIterator(player, maxDistance);
		Block block = null;
		while(iter.hasNext()){
			block = iter.next();
			if(block.getType() != Material.AIR){
				break;
			}
		}
		
		if(block != null){
			if(!players.containsKey(player)){
				players.put(player, new BlockTime(block, 0));
			}
			else{
				long stareTimeMillis = players.get(player).elapsedMillis += elapsed;
				if(stareTimeMillis >= plugin.getMinTime()){
					Random r = new Random();
					int poss = calcBalancedPossibility();
					if(r.nextInt(poss) == 0){
						Bukkit.getServer().getPluginManager().callEvent(new PlayerStareEvent(player, block));
						players.remove(player);
					}
					else{
						long elapsedMillis = players.get(player).getElapsedMillis();
						elapsedMillis += elapsed;
						players.get(player).setElapsedMillis(elapsedMillis);
					}
				}
			}
		}
	}
	
	private int calcBalancedPossibility(){
		long period = plugin.getPeriod();
		int range = plugin.getMaxTime() - plugin.getMinTime();
		//Provisional calculation
		return (int) (20 / period * range * 1.5);
	}

}
