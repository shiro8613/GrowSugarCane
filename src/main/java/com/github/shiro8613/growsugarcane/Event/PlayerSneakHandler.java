package com.github.shiro8613.growsugarcane.Event;

import com.github.shiro8613.growsugarcane.Logic.ClickLogic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.github.shiro8613.growsugarcane.Logic.SneakLogic;

public class PlayerSneakHandler implements Listener {


    private SneakLogic sneakLogic = new SneakLogic();
    private ClickLogic clickLogic = new ClickLogic();


    //プレーヤースニークを取得
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        sneakLogic.Action(event.getPlayer()); //sneakLogicに処理を渡す
    }

    //プレーヤーのクリックを取得
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        clickLogic.Action(event.getPlayer()); //clickLoginに処理を渡す
    }

}