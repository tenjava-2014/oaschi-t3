package com.tenjava.entries.oaschi.t3;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.tenjava.entries.oaschi.t3.commands.CmdDisable;
import com.tenjava.entries.oaschi.t3.commands.CmdEnable;

public class Quantumizer extends JavaPlugin {
	
	public static Quantumizer plugin;
	
	public Logger logger = this.getLogger();
	private boolean active = false;
	private Mode mode = Mode.LSD;
	/**
	 * The max distance between a player and a potential target for an random event.
	 */
	private int maxDistance = 10;
	private int taskId;
	/**
	 * The min/max time the player has to stare at something to trigger a random event.
	 */
	private int minTime;
	private int maxTime;
	/**
	 * The period of the repeating task in ticks.
	 */
	private long period = 4;
	
	@Override
	public void onEnable(){
		Quantumizer.plugin = this;
		setCommandExecutors();
	}
	
	private void start(){
		if(active) return;
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		this.taskId = scheduler.scheduleSyncRepeatingTask(plugin, new StalkerTask(), 0L, 4L);
	}
	
	private void setCommandExecutors(){
		getCommand("quen").setExecutor(new CmdEnable());
		getCommand("qudis").setExecutor(new CmdDisable());
	}
	
	@Override
	public void onDisable(){
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		if(active == true){
			start();
		}
		this.active = active;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getTaskId() {
		return taskId;
	}

	public int getMinTime() {
		return minTime;
	}

	public void setMinTime(int minTime) {
		this.minTime = minTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}
	
}
