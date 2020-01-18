package me.border.Ironfall;

import me.border.Ironfall.listeners.ironFallListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new ironFallListener(this), this);
    }

}