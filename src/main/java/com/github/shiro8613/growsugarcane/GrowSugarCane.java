package com.github.shiro8613.growsugarcane;

import com.github.shiro8613.growsugarcane.Event.PlayerSneakHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrowSugarCane extends JavaPlugin {

    public static int coolDownTick; //クールダウン
    public static int interferenceRadius; //干渉範囲
    public static int maxGrowth; //最大成長数

    @Override
    public void onEnable() {

        Configuration config = getConfig(); //コンフィグをconfigとして定義
        coolDownTick = config.getInt("coolDownTick", 5); //クールダウンを設定
        interferenceRadius = config.getInt("interferenceRadius", 7); //干渉範囲を設定
        maxGrowth = config.getInt("maxGrowth", 3); //最大成長数
        saveDefaultConfig(); //通常設定を保存

        getServer().getPluginManager().registerEvents(new PlayerSneakHandler(), this); //イベントハンドラーを登録
    }

    @Override
    public void onDisable() {
        // つかわないよーん
    }
}
