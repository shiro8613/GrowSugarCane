package com.github.shiro8613.growsugarcane.Logic;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class Memory {

    private final int i;

    public Memory(int i) {
        this.i = i;
    }

    private final Map<Player, Integer> PlayerMemory = new HashMap<>();

    public boolean getMemory(Player player) {

        if (PlayerMemory.get(player) == null) {
            PlayerMemory.put(player, 1);
            return false;
        }

        if (PlayerMemory.get(player).equals(i)) {
            PlayerMemory.remove(player);
            return true;
        }

        PlayerMemory.replace(player, PlayerMemory.get(player) + 1);
        return false;
    }
}
