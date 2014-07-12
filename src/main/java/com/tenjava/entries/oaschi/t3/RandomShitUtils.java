package com.tenjava.entries.oaschi.t3;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.metadata.Metadatable;

public class RandomShitUtils {
	
	private int randomShitQuantity = 1;
	
	/**
	 * Replaces the target object with a
	 * random other object of the same
	 * type (Block, Creature) for a split second.
	 */
	public static void flash(Player player, Metadatable target){
		if(target instanceof Block){
			Block targetBlock = (Block) target;
			flashBlock(player, targetBlock);
		}
		else if(target instanceof Creature){
			Creature targetCreature = (Creature) target;
			flashCreature(player, targetCreature);
		}
	}
	
	private static void flashCreature(Player player, Creature targetCreature) {
		
	}

	private static void flashBlock(Player player, Block target){
		
	}

}
