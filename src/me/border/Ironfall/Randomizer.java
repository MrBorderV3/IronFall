package me.border.Ironfall;

import org.bukkit.Material;
import org.bukkit.entity.IronGolem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public static void randomItem(IronGolem golem){
        golem.getWorld().dropItem(golem.getLocation(), new ItemStack(Material.IRON_INGOT, new Random().nextInt(3)));
    }
}
