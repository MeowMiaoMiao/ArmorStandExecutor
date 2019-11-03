package net.wdsj.bukkit.armorstandexecutor.armor.component;

import org.bukkit.entity.Player;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/10/25 18:02
 */
public class MessageComponent extends ArmorComponent {

    public MessageComponent(String key) {
        super(key);
    }

    @Override
    public void execute(Player player, String value) {
        String[] split = value.split(";");
        for (String s : split) {
           player.sendMessage(s.replace("&","§").replace("{player}" , player.getName()));
        }
    }


}
