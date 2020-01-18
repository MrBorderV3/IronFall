package me.border.Ironfall.listeners;

import me.border.Ironfall.Main;
import me.border.Ironfall.Randomizer;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ironFallListener implements Listener {

    private Main plugin;

    public ironFallListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void ironFall(SpawnerSpawnEvent e) {
        if (e.getEntity() instanceof IronGolem) {
            IronGolem golem = (IronGolem) e.getEntity();
            new BukkitRunnable() {
                float falldis = 0;

                @Override
                public void run() {
                    if (golem.getFallDistance() > 0 && !golem.isOnGround()) {
                        falldis = golem.getFallDistance();
                    } else if (golem.isOnGround()) {
                        if (falldis >= 15) {
                            falldis = 100;
                            golem.damage(falldis);
                        }
                    }
                }
            }.runTaskTimer(plugin, 0, 2);
        }
    }

    @EventHandler
    public void ironDeath(EntityDeathEvent e){
        if (e.getEntity() instanceof IronGolem){
            IronGolem golem = (IronGolem) e.getEntity();
            e.getDrops().clear();
            Randomizer.randomItem(golem);
        }
    }

}
