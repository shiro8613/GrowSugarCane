package com.github.shiro8613.growsugarcane.Logic;

import com.github.shiro8613.growsugarcane.GrowSugarCane;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SneakLogic {

    private final Random rand = new Random();

    private final Memory memory = new Memory(6);

    public void Action(@NotNull Player player) {

        if(player.isFlying()) return; //飛んでいたら無視
        if(!player.isSneaking()) return; //スニークしてないと無視

        Location location = player.getLocation();

        if (!memory.getMemory(player)) return;

        List<Location> ListLocation = new ArrayList<>();

        World world = player.getWorld();

        int BlockX = location.getBlockX();
        int BlockY = location.getBlockY();
        int BlockZ = location.getBlockZ();

        int radius = GrowSugarCane.interferenceRadius;
        int max = GrowSugarCane.maxGrowth;

        for(int X=-radius; X <= radius; X++) {
            for(int Y=-radius; Y <= radius; Y++) {
                for(int Z=-radius; Z <= radius; Z++) {

                    int Xp = BlockX + X;
                    int Yp = BlockY + Y;
                    int Zp = BlockZ + Z;

                    Block blockP1 = world.getBlockAt(Xp, Yp-(max -1), Zp);
                    if (blockP1.getType().equals(Material.SUGAR_CANE)) continue;

                    Block block = world.getBlockAt(Xp, Yp, Zp);
                    Location newLocation = new Location(world, Xp, Yp+1, Zp);
                    if (block.getType().equals(Material.SUGAR_CANE)) ListLocation.add(newLocation);
                }
            }
        }

        if (ListLocation.isEmpty()) return;

        int listSize = ListLocation.size();
        int count = rand.nextInt(max, listSize);

        if (listSize >= max) {
            for (int i = 0; i < count; i++) {
                int r = rand.nextInt(listSize);
                Location blockLocation = ListLocation.get(r);
                world.setBlockData(blockLocation, Material.SUGAR_CANE.createBlockData());
                player.spawnParticle(Particle.VILLAGER_HAPPY, blockLocation, 5, .2, .2, .2);
            }
        } else ListLocation.forEach(x -> {
                world.setBlockData(x, Material.SUGAR_CANE.createBlockData());
                player.spawnParticle(Particle.VILLAGER_HAPPY, x, 5, .2, .2,.2);
        });
    }
}
