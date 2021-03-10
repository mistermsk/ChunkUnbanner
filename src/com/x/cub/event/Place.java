package com.x.cub.event;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class Place implements Listener {
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(e.getBlock().getType().equals(Material.FURNACE)||e.getBlock().getType().equals(Material.CHEST)) {
			Chunk c = e.getBlock().getLocation().getChunk();
			if(getAll(c, Material.FURNACE)>200) {
				e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.FURNACE, 1));
				e.getBlock().setType(Material.AIR);
			} else if(getAll(c, Material.CHEST)>300) {
				e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.CHEST, 1));
				e.getBlock().setType(Material.AIR);
			}
		}
	}
	
	public int getAll(Chunk c, Material m) {
		int a = 0;
		for(int x=0;x<16;x++)
			for(int y=0;y<255;y++)
				for(int z=0;z<16;z++)
					if(new Location(c.getWorld(), c.getX()*x, y, c.getZ()*z).getBlock().getType().equals(m))
						a++;
		return a;
	}

}
