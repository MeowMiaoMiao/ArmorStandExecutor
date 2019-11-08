package net.wdsj.bukkit.armorstandexecutor.armor.component;

import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import net.wdsj.bukkit.armorstandexecutor.ArmorStandExecutor;
import org.bukkit.entity.Player;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/10/25 18:01
 */
@Getter
public abstract class ArmorComponent {

    private String key;


    ArmorComponent(String key) {
        this.key = key;
    }


    public abstract boolean execute(Player player, String value);


    protected String[] format(Player player, String value) {
        if (ArmorStandExecutor.PLACEHOLDER_API_ENABLE) {
            value = PlaceholderAPI.setBracketPlaceholders(player, value);
        }
        return value.split(";");
    }


}
