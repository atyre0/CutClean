package me.atyre.cutclean;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CutCleanCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (CutClean.isCutCleanEnabled()) {
            CutClean.setCutCleanEnabled(false);
            sender.sendMessage(ChatColor.RED + "You have disabled Cut Clean.");
        } else {
            CutClean.setCutCleanEnabled(true);
            sender.sendMessage(ChatColor.GREEN + "You have enabled Cut Clean.");
        }
        return false;
    }
}
