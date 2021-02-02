package me.atyre.cutclean;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CutCleanListener implements Listener {

    @EventHandler
    public void onMine(BlockBreakEvent event) {
        if (CutClean.isCutCleanEnabled()) {
            if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
                return;
            }

            if (event.getBlock().getType() == Material.IRON_ORE) {
                Location location = event.getBlock().getLocation();
                World world = location.getWorld();
                event.getBlock().setType(Material.AIR);
                world.dropItem(location, new ItemStack(Material.IRON_INGOT));
                event.setExpToDrop(4);
            }

            if (event.getBlock().getType() == Material.GOLD_ORE) {
                Location location = event.getBlock().getLocation();
                World world = event.getBlock().getWorld();
                event.getBlock().setType(Material.AIR);
                world.dropItem(location, new ItemStack(Material.GOLD_INGOT));
                event.setExpToDrop(5);
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (CutClean.isCutCleanEnabled()) {
            if (event.getEntity() instanceof Pig) {
                event.getDrops().clear();

                ItemStack cookedPork = new ItemStack(Material.GRILLED_PORK);
                int lootingLevel = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
                int amount = NumberUtil.generateRandomNumberWithLooting(1, 3, lootingLevel);
                cookedPork.setAmount(amount);

                event.getDrops().add(cookedPork);
            }

            if (event.getEntity() instanceof Cow) {
                event.getDrops().clear();

                ItemStack cookedBeef = new ItemStack(Material.COOKED_BEEF);
                int lootingLevel = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
                int amount = NumberUtil.generateRandomNumberWithLooting(1, 3, lootingLevel);
                cookedBeef.setAmount(amount);

                ItemStack leather = new ItemStack(Material.LEATHER);
                int amount2 = NumberUtil.generateRandomNumberWithLooting(0, 2, lootingLevel);
                cookedBeef.setAmount(amount2);

                event.getDrops().add(cookedBeef);
                event.getDrops().add(leather);
            }

            if (event.getEntity() instanceof Sheep) {
                event.getDrops().clear();

                ItemStack mutton = new ItemStack(Material.COOKED_MUTTON);
                int lootingLevel = event.getEntity().getKiller().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
                int amount = NumberUtil.generateRandomNumberWithLooting(1, 2, lootingLevel);
                mutton.setAmount(amount);

                byte dyeColor = ((Sheep) event.getEntity()).getColor().getData();

                ItemStack wool = new ItemStack(Material.WOOL, 1, dyeColor);

                event.getDrops().add(mutton);
                event.getDrops().add(wool);
            }
        }
    }
}
