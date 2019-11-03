package net.wdsj.bukkit.armorstandexecutor.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 20:46
 */
public class BukkitUtils {

    public static void executeCommand(String cmd, Player player) {
        if (cmd.startsWith("op:")) {
            player.setOp(true);
            Bukkit.dispatchCommand(player, cmd.replace("op:", ""));
            player.setOp(false);
        } else if (cmd.startsWith("console:")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("console:", ""));
        } else if (cmd.startsWith("broadcast:")) {
            Bukkit.broadcastMessage(cmd.replace("broadcast:", ""));
        }

    }

}
