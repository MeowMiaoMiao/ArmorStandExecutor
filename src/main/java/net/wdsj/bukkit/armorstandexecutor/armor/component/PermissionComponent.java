package net.wdsj.bukkit.armorstandexecutor.armor.component;

import org.bukkit.entity.Player;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/10/25 18:02
 */
public class PermissionComponent extends ArmorComponent {

    public PermissionComponent(String key) {
        super(key);
    }

    @Override
    public boolean execute(Player player, String value) {
        for (String s : format( player , value)) {
            if (!player.hasPermission(s)){
                return false;
            }
        }
        return true;
    }


}
