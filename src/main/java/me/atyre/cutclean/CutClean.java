package me.atyre.cutclean;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CutClean extends JavaPlugin {

    private static CutClean instance;

    private static boolean cutCleanEnabled = false;

    private static String cutCleanPrefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "CutClean" + ChatColor.GRAY + "]";

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(new CutCleanListener(), this);
        this.getCommand("cutclean").setExecutor(new CutCleanCommand());
    }

    @Override
    public void onDisable() {
        instance = null;

    }

    public static CutClean getInstance() {
        return instance;
    }

    public static boolean isCutCleanEnabled() {
        return cutCleanEnabled;
    }

    public static void setCutCleanEnabled(boolean cutCleanEnabled) {
        CutClean.cutCleanEnabled = cutCleanEnabled;
    }

    public static String getCutCleanPrefix() {
        return cutCleanPrefix;
    }
}
