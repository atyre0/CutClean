package me.atyre.cutclean;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CutCleanCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("cutclean.command")) {
                if (CutClean.isCutCleanEnabled()) {
                    CutClean.setCutCleanEnabled(false);
                    player.sendMessage(CutClean.getCutCleanPrefix() + ChatColor.RED + " You have disabled Cut Clean.");
                    Bukkit.broadcastMessage(CutClean.getCutCleanPrefix() + ChatColor.RED +" Cut Clean was disabled.");
                } else {
                    CutClean.setCutCleanEnabled(true);
                    player.sendMessage(CutClean.getCutCleanPrefix() + ChatColor.GREEN + " You have enabled Cut Clean.");
                    Bukkit.broadcastMessage(CutClean.getCutCleanPrefix() + ChatColor.GREEN +" Cut Clean was enabled.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permissions to execute this command.");
            }
        } else {
            if (CutClean.isCutCleanEnabled()) {
                CutClean.setCutCleanEnabled(false);
                sender.sendMessage(CutClean.getCutCleanPrefix() + ChatColor.RED + " You have disabled Cut Clean.");
                Bukkit.broadcastMessage(CutClean.getCutCleanPrefix() + ChatColor.RED +" Cut Clean was disabled.");
            } else {
                CutClean.setCutCleanEnabled(true);
                sender.sendMessage(CutClean.getCutCleanPrefix() + ChatColor.GREEN + " You have enabled Cut Clean.");
                Bukkit.broadcastMessage(CutClean.getCutCleanPrefix() + ChatColor.GREEN +" Cut Clean was enabled.");
            }
        }
        return false;
    }
}
