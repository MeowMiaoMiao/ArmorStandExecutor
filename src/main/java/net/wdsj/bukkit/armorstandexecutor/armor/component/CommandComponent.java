package net.wdsj.bukkit.armorstandexecutor.armor.component;

import net.wdsj.bukkit.armorstandexecutor.utils.BukkitUtils;
import org.bukkit.entity.Player;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/10/25 18:02
 */
public class CommandComponent extends ArmorComponent {

    public CommandComponent(String key) {
        super(key);
    }

    @Override
    public void execute(Player player, String value) {
        String[] split = value.split(";");
        for (String s : split) {
            BukkitUtils.executeCommand(s.replace("{player}" , player.getName()), player);
        }
    }


}
