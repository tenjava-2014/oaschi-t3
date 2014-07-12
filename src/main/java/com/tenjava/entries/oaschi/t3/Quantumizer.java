package com.tenjava.entries.oaschi.t3;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.oaschi.t3.commands.*;

public class Quantumizer extends JavaPlugin {
	
	public static Quantumizer plugin;
	
	private Logger logger = this.getLogger();
	/**
	 * Self-explanatory
	 */
	private boolean active = false;
	
	private Mode mode = Mode.LSD;
	
	@Override
	public void onEnable(){
		Quantumizer.plugin = this;
		setCommandExecutors();
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
		this.active = active;
	}
	
}
