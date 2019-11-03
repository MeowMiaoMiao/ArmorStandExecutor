package net.wdsj.bukkit.armorstandexecutor.armor.component;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

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


    public abstract void execute(Player player, String value);


}
