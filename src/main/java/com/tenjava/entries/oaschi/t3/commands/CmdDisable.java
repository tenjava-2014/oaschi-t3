package com.tenjava.entries.oaschi.t3.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.oaschi.t3.Quantumizer;

public class CmdDisable implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Quantumizer.plugin.setActive(false);
		return true;
	}

}
